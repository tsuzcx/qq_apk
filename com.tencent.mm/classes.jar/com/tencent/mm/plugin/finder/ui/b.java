package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.service.p;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.d;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.protocal.protobuf.avo;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.bpp;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"MENU_ID_ADD_BLACK_LIST", "", "addBlackListener", "Lkotlin/Function3;", "", "Landroid/content/Context;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "", "getAddBlackListener", "()Lkotlin/jvm/functions/Function3;", "clickFansItem", "Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;", "fansContact", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "context", "Lkotlin/Function1;", "plugin-finder_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final q<String, Context, ck<bpp>, ah> FQz = (q)a.FQA;
  
  public static final d a(axc paramaxc, Context paramContext, kotlin.g.a.b<? super String, ah> paramb)
  {
    AppMethodBeat.i(346569);
    s.u(paramaxc, "fansContact");
    s.u(paramContext, "context");
    Intent localIntent = new Intent();
    Object localObject = paramaxc.contact;
    String str;
    label64:
    label89:
    label114:
    int i;
    if (localObject == null)
    {
      str = null;
      localObject = str;
      if (str == null)
      {
        localObject = paramaxc.contact;
        if (localObject != null) {
          break label367;
        }
        localObject = "";
      }
      localIntent.putExtra("Username", (String)localObject);
      localObject = paramaxc.contact;
      if (localObject != null) {
        break label409;
      }
      localObject = "";
      localIntent.putExtra("Nickname", (String)localObject);
      localObject = paramaxc.contact;
      if (localObject != null) {
        break label432;
      }
      localObject = "";
      localIntent.putExtra("Avatar", (String)localObject);
      localObject = paramaxc.contact;
      if (localObject != null) {
        break label455;
      }
      localObject = "";
      label139:
      localIntent.putExtra("Signature", (String)localObject);
      localObject = paramaxc.contact;
      if (localObject != null) {
        break label478;
      }
      i = 0;
      label162:
      localIntent.putExtra("Sex", i);
      localObject = paramaxc.contact;
      if (localObject != null) {
        break label504;
      }
      localObject = "";
      label186:
      localIntent.putExtra("Province", (String)localObject);
      localObject = paramaxc.contact;
      if (localObject != null) {
        break label546;
      }
      localObject = "";
      label211:
      localIntent.putExtra("City", (String)localObject);
      localObject = paramaxc.contact;
      if (localObject != null) {
        break label588;
      }
      localObject = "";
      label236:
      localIntent.putExtra("Country", (String)localObject);
      if (paramaxc.displayFlag == 0) {
        localIntent.putExtra("Action", 1);
      }
      localIntent.putExtra("FansId", paramaxc.hJS);
      localObject = paramaxc.contact;
      if (localObject != null) {
        break label630;
      }
      localObject = "";
      label289:
      localIntent.putExtra("V5UserName", (String)localObject);
      localObject = paramaxc.contact;
      if (localObject != null) {
        break label653;
      }
      localObject = null;
    }
    for (;;)
    {
      localIntent.putExtra("ContactMsgInfo", (byte[])localObject);
      localIntent.putExtra("IsPoster", true);
      localObject = av.GiL;
      paramaxc = av.a(paramContext, paramaxc.username, localIntent, 1, paramb);
      AppMethodBeat.o(346569);
      return paramaxc;
      str = ((FinderContact)localObject).username;
      break;
      label367:
      localObject = ((FinderContact)localObject).msgInfo;
      if (localObject == null)
      {
        localObject = "";
        break label64;
      }
      str = ((avo)localObject).ZFM;
      localObject = str;
      if (str != null) {
        break label64;
      }
      localObject = "";
      break label64;
      label409:
      str = ((FinderContact)localObject).nickname;
      localObject = str;
      if (str != null) {
        break label89;
      }
      localObject = "";
      break label89;
      label432:
      str = ((FinderContact)localObject).headUrl;
      localObject = str;
      if (str != null) {
        break label114;
      }
      localObject = "";
      break label114;
      label455:
      str = ((FinderContact)localObject).signature;
      localObject = str;
      if (str != null) {
        break label139;
      }
      localObject = "";
      break label139;
      label478:
      localObject = ((FinderContact)localObject).extInfo;
      if (localObject == null)
      {
        i = 0;
        break label162;
      }
      i = ((avl)localObject).sex;
      break label162;
      label504:
      localObject = ((FinderContact)localObject).extInfo;
      if (localObject == null)
      {
        localObject = "";
        break label186;
      }
      str = ((avl)localObject).province;
      localObject = str;
      if (str != null) {
        break label186;
      }
      localObject = "";
      break label186;
      label546:
      localObject = ((FinderContact)localObject).extInfo;
      if (localObject == null)
      {
        localObject = "";
        break label211;
      }
      str = ((avl)localObject).city;
      localObject = str;
      if (str != null) {
        break label211;
      }
      localObject = "";
      break label211;
      label588:
      localObject = ((FinderContact)localObject).extInfo;
      if (localObject == null)
      {
        localObject = "";
        break label236;
      }
      str = ((avl)localObject).country;
      localObject = str;
      if (str != null) {
        break label236;
      }
      localObject = "";
      break label236;
      label630:
      str = ((FinderContact)localObject).wx_username_v5;
      localObject = str;
      if (str != null) {
        break label289;
      }
      localObject = "";
      break label289;
      label653:
      localObject = ((FinderContact)localObject).msgInfo;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((avo)localObject).toByteArray();
      }
    }
  }
  
  public static final q<String, Context, ck<bpp>, ah> fbc()
  {
    return FQz;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "fansId", "", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements q<String, Context, ck<bpp>, ah>
  {
    public static final a FQA;
    
    static
    {
      AppMethodBeat.i(347007);
      FQA = new a();
      AppMethodBeat.o(347007);
    }
    
    a()
    {
      super();
    }
    
    private static final void a(String paramString, ck paramck, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(347001);
      p localp = (p)h.ax(p.class);
      paramDialogInterface = paramString;
      if (paramString == null) {
        paramDialogInterface = "";
      }
      localp.b(paramDialogInterface, true, paramck);
      AppMethodBeat.o(347001);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.b
 * JD-Core Version:    0.7.0.1
 */