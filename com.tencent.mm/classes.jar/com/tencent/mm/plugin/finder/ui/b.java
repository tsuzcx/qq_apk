package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.service.k;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.asn;
import com.tencent.mm.protocal.protobuf.beo;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"MENU_ID_ADD_BLACK_LIST", "", "addBlackListener", "Lkotlin/Function3;", "", "Landroid/content/Context;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "", "getAddBlackListener", "()Lkotlin/jvm/functions/Function3;", "clickFansItem", "Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;", "fansContact", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "context", "Lkotlin/Function1;", "plugin-finder_release"})
public final class b
{
  private static final kotlin.g.a.q<String, Context, com.tencent.mm.plugin.findersdk.a.aj<beo>, x> AqL = (kotlin.g.a.q)a.AqM;
  
  public static final e a(asn paramasn, Context paramContext, kotlin.g.a.b<? super String, x> paramb)
  {
    AppMethodBeat.i(280905);
    p.k(paramasn, "fansContact");
    p.k(paramContext, "context");
    Intent localIntent = new Intent();
    Object localObject = paramasn.contact;
    String str;
    if (localObject != null)
    {
      str = ((FinderContact)localObject).username;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = paramasn.contact;
      if (localObject != null)
      {
        localObject = ((FinderContact)localObject).msgInfo;
        if (localObject != null)
        {
          str = ((arg)localObject).SEn;
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
    localObject = paramasn.contact;
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
    localObject = paramasn.contact;
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
    localObject = paramasn.contact;
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
    localObject = paramasn.contact;
    int i;
    if (localObject != null)
    {
      localObject = ((FinderContact)localObject).extInfo;
      if (localObject != null)
      {
        i = ((ard)localObject).sex;
        localIntent.putExtra("Sex", i);
        localObject = paramasn.contact;
        if (localObject != null)
        {
          localObject = ((FinderContact)localObject).extInfo;
          if (localObject != null)
          {
            str = ((ard)localObject).province;
            localObject = str;
            if (str != null) {
              break label310;
            }
          }
        }
        localObject = "";
        label310:
        localIntent.putExtra("Province", (String)localObject);
        localObject = paramasn.contact;
        if (localObject != null)
        {
          localObject = ((FinderContact)localObject).extInfo;
          if (localObject != null)
          {
            str = ((ard)localObject).city;
            localObject = str;
            if (str != null) {
              break label363;
            }
          }
        }
        localObject = "";
        label363:
        localIntent.putExtra("City", (String)localObject);
        localObject = paramasn.contact;
        if (localObject != null)
        {
          localObject = ((FinderContact)localObject).extInfo;
          if (localObject != null)
          {
            str = ((ard)localObject).country;
            localObject = str;
            if (str != null) {
              break label416;
            }
          }
        }
        localObject = "";
        label416:
        localIntent.putExtra("Country", (String)localObject);
        if (paramasn.displayFlag == 0) {
          localIntent.putExtra("Action", 1);
        }
        localIntent.putExtra("FansId", paramasn.fFa);
        localObject = paramasn.contact;
        if (localObject != null)
        {
          str = ((FinderContact)localObject).wx_username_v5;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localIntent.putExtra("V5UserName", (String)localObject);
        localObject = paramasn.contact;
        if (localObject == null) {
          break label574;
        }
        localObject = ((FinderContact)localObject).msgInfo;
        if (localObject == null) {
          break label574;
        }
      }
    }
    label574:
    for (localObject = ((arg)localObject).toByteArray();; localObject = null)
    {
      localIntent.putExtra("ContactMsgInfo", (byte[])localObject);
      localIntent.putExtra("IsPoster", true);
      localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
      paramasn = com.tencent.mm.plugin.finder.utils.aj.a(paramContext, paramasn.username, localIntent, 1, paramb);
      AppMethodBeat.o(280905);
      return paramasn;
      i = 0;
      break;
    }
  }
  
  public static final kotlin.g.a.q<String, Context, com.tencent.mm.plugin.findersdk.a.aj<beo>, x> eao()
  {
    return AqL;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "fansId", "", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.q<String, Context, com.tencent.mm.plugin.findersdk.a.aj<beo>, x>
  {
    public static final a AqM;
    
    static
    {
      AppMethodBeat.i(230374);
      AqM = new a();
      AppMethodBeat.o(230374);
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