package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.d;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.aqr;
import com.tencent.mm.protocal.protobuf.ayt;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"MENU_ID_ADD_BLACK_LIST", "", "addBlackListener", "Lkotlin/Function3;", "", "Landroid/content/Context;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "", "getAddBlackListener", "()Lkotlin/jvm/functions/Function3;", "clickFansItem", "Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;", "fansContact", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "context", "Lkotlin/Function1;", "plugin-finder_release"})
public final class b
{
  private static final kotlin.g.a.q<String, Context, ai<ayt>, x> vJT = (kotlin.g.a.q)a.vJU;
  
  public static final d a(aqr paramaqr, Context paramContext, kotlin.g.a.b<? super String, x> paramb)
  {
    AppMethodBeat.i(252327);
    p.h(paramaqr, "fansContact");
    p.h(paramContext, "context");
    Intent localIntent = new Intent();
    Object localObject = paramaqr.contact;
    String str;
    if (localObject != null)
    {
      str = ((FinderContact)localObject).username;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = paramaqr.contact;
      if (localObject != null)
      {
        localObject = ((FinderContact)localObject).msgInfo;
        if (localObject != null)
        {
          str = ((aps)localObject).LBC;
          localObject = str;
          if (str != null) {
            break label96;
          }
        }
      }
      localObject = "";
    }
    label96:
    localIntent.putExtra("Username", (String)localObject);
    localObject = paramaqr.contact;
    if (localObject != null)
    {
      str = ((FinderContact)localObject).nickname;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localIntent.putExtra("Nickname", (String)localObject);
    localObject = paramaqr.contact;
    if (localObject != null)
    {
      str = ((FinderContact)localObject).headUrl;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localIntent.putExtra("Avatar", (String)localObject);
    localObject = paramaqr.contact;
    if (localObject != null)
    {
      str = ((FinderContact)localObject).signature;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localIntent.putExtra("Signature", (String)localObject);
    localObject = paramaqr.contact;
    int i;
    if (localObject != null)
    {
      localObject = ((FinderContact)localObject).extInfo;
      if (localObject != null)
      {
        i = ((app)localObject).fuA;
        localIntent.putExtra("Sex", i);
        localObject = paramaqr.contact;
        if (localObject != null)
        {
          localObject = ((FinderContact)localObject).extInfo;
          if (localObject != null)
          {
            str = ((app)localObject).fuJ;
            localObject = str;
            if (str != null) {
              break label310;
            }
          }
        }
        localObject = "";
        label310:
        localIntent.putExtra("Province", (String)localObject);
        localObject = paramaqr.contact;
        if (localObject != null)
        {
          localObject = ((FinderContact)localObject).extInfo;
          if (localObject != null)
          {
            str = ((app)localObject).fuK;
            localObject = str;
            if (str != null) {
              break label363;
            }
          }
        }
        localObject = "";
        label363:
        localIntent.putExtra("City", (String)localObject);
        localObject = paramaqr.contact;
        if (localObject != null)
        {
          localObject = ((FinderContact)localObject).extInfo;
          if (localObject != null)
          {
            str = ((app)localObject).country;
            localObject = str;
            if (str != null) {
              break label416;
            }
          }
        }
        localObject = "";
        label416:
        localIntent.putExtra("Country", (String)localObject);
        if (paramaqr.displayFlag == 0) {
          localIntent.putExtra("Action", 1);
        }
        localIntent.putExtra("FansId", paramaqr.dMj);
        localObject = paramaqr.contact;
        if (localObject == null) {
          break label523;
        }
        localObject = ((FinderContact)localObject).msgInfo;
        if (localObject == null) {
          break label523;
        }
      }
    }
    label523:
    for (localObject = ((aps)localObject).toByteArray();; localObject = null)
    {
      localIntent.putExtra("ContactMsgInfo", (byte[])localObject);
      localObject = y.vXH;
      paramaqr = y.a(paramContext, paramaqr.username, localIntent, paramb);
      AppMethodBeat.o(252327);
      return paramaqr;
      i = 0;
      break;
    }
  }
  
  public static final kotlin.g.a.q<String, Context, ai<ayt>, x> dzu()
  {
    return vJT;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "fansId", "", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.q<String, Context, ai<ayt>, x>
  {
    public static final a vJU;
    
    static
    {
      AppMethodBeat.i(252326);
      vJU = new a();
      AppMethodBeat.o(252326);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.b
 * JD-Core Version:    0.7.0.1
 */