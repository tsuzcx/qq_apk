package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.ringtone.g.d;
import com.tencent.mm.plugin.ringtone.g.d.a;
import com.tencent.mm.plugin.ringtone.widget.c;
import com.tencent.mm.plugin.ringtone.widget.c.a;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderRingToneUtil;", "", "()V", "isSetRingTone", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "shareToRingTone", "", "context", "Landroidx/appcompat/app/AppCompatActivity;", "feedOp", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isPause", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class al
{
  public static final al GhB;
  
  static
  {
    AppMethodBeat.i(333539);
    GhB = new al();
    AppMethodBeat.o(333539);
  }
  
  public static void a(AppCompatActivity paramAppCompatActivity, BaseFinderFeed paramBaseFinderFeed, b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(333524);
    s.u(paramAppCompatActivity, "context");
    s.u(paramBaseFinderFeed, "feed");
    s.u(paramb, "feedOp");
    FinderObject localFinderObject = paramBaseFinderFeed.feedObject.getFinderObject();
    if (localFinderObject == null)
    {
      AppMethodBeat.o(333524);
      return;
    }
    FinderObjectDesc localFinderObjectDesc = localFinderObject.objectDesc;
    if (localFinderObjectDesc == null)
    {
      AppMethodBeat.o(333524);
      return;
    }
    Object localObject = "";
    Iterator localIterator = ((Iterable)paramBaseFinderFeed.feedObject.getTopicList()).iterator();
    for (paramBaseFinderFeed = (BaseFinderFeed)localObject; localIterator.hasNext(); paramBaseFinderFeed = paramBaseFinderFeed + ' ' + ((bo)localObject).topic) {
      localObject = (bo)localIterator.next();
    }
    localObject = d.ODu;
    localObject = localFinderObjectDesc.media.getFirst();
    s.s(localObject, "media.media.first");
    paramBaseFinderFeed = d.a.a(localFinderObject, (FinderMedia)localObject, paramBaseFinderFeed);
    localObject = c.OGk;
    localObject = (Context)paramAppCompatActivity;
    paramAppCompatActivity = paramAppCompatActivity.getLifecycle();
    s.s(paramAppCompatActivity, "context.lifecycle");
    c.a.a((Context)localObject, paramAppCompatActivity, paramBaseFinderFeed, (b)new al.a(paramb));
    AppMethodBeat.o(333524);
  }
  
  public static boolean m(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(333532);
    s.u(paramBaseFinderFeed, "feed");
    FinderObject localFinderObject = paramBaseFinderFeed.feedObject.getFinderObject();
    FinderObjectDesc localFinderObjectDesc = localFinderObject.objectDesc;
    if (localFinderObjectDesc == null)
    {
      AppMethodBeat.o(333532);
      return false;
    }
    Object localObject = "";
    Iterator localIterator = ((Iterable)paramBaseFinderFeed.feedObject.getTopicList()).iterator();
    for (paramBaseFinderFeed = (BaseFinderFeed)localObject; localIterator.hasNext(); paramBaseFinderFeed = paramBaseFinderFeed + ' ' + ((bo)localObject).topic) {
      localObject = (bo)localIterator.next();
    }
    localObject = d.ODu;
    localObject = localFinderObjectDesc.media.getFirst();
    s.s(localObject, "media.media.first");
    paramBaseFinderFeed = d.a.a(localFinderObject, (FinderMedia)localObject, paramBaseFinderFeed);
    localObject = c.OGk;
    boolean bool = c.a.d(paramBaseFinderFeed);
    AppMethodBeat.o(333532);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.al
 * JD-Core Version:    0.7.0.1
 */