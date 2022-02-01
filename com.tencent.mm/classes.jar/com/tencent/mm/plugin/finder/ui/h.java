package com.tencent.mm.plugin.finder.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.q;
import com.tencent.mm.plugin.finder.convert.t;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.feed.k.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "(ILcom/tencent/mm/ui/MMActivity;Z)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkExposeCommentStrategy", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends k.a
{
  String TAG;
  
  public h(int paramInt, MMActivity paramMMActivity, boolean paramBoolean)
  {
    super(paramInt, paramMMActivity, paramBoolean, false, 8);
    AppMethodBeat.i(346351);
    this.TAG = "Finder.FinderShareFeedDetailUI";
    AppMethodBeat.o(346351);
  }
  
  public final com.tencent.mm.view.recyclerview.g dUK()
  {
    AppMethodBeat.i(167708);
    com.tencent.mm.view.recyclerview.g localg = (com.tencent.mm.view.recyclerview.g)new a(this);
    AppMethodBeat.o(167708);
    return localg;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "getLikeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.recyclerview.g
  {
    a(h paramh) {}
    
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(167707);
      switch (paramInt)
      {
      case 3: 
      default: 
        localObject = av.GiL;
        av.eY(this.FVL.TAG, paramInt);
        localObject = (f)new com.tencent.mm.plugin.finder.convert.g();
        AppMethodBeat.o(167707);
        return localObject;
      case 4: 
        localObject = (f)new t(this.FVL.AJn, (i)this.FVL, false, 0, 12);
        AppMethodBeat.o(167707);
        return localObject;
      }
      Object localObject = (f)new q((i)this.FVL, false, 0, 6);
      AppMethodBeat.o(167707);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.h
 * JD-Core Version:    0.7.0.1
 */