package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper;
import com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper.Companion;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderPostPreCheckHelper;", "", "()V", "BINDER_PHONE_SCENE_CREATE_ACCDOUNT", "", "getBINDER_PHONE_SCENE_CREATE_ACCDOUNT", "()I", "BINDER_PHONE_SCENE_POST", "getBINDER_PHONE_SCENE_POST", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkHasBindPhone", "", "context", "Landroid/content/Context;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "formScene", "onGoBindPhoneListener", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)Z", "goToBindPhoneUI", "preCheck", "Landroid/app/Activity;", "resp", "onGoVertifyPage", "plugin-finder_release"})
public final class w
{
  private static final int ADX = 1;
  private static final int ADY = 2;
  public static final w ADZ;
  private static final String TAG = "FinderPostPreCheckHelper";
  
  static
  {
    AppMethodBeat.i(271467);
    ADZ = new w();
    TAG = "FinderPostPreCheckHelper";
    ADX = 1;
    ADY = 2;
    AppMethodBeat.o(271467);
  }
  
  public static boolean a(Activity paramActivity, ble paramble, final kotlin.g.a.a<x> parama)
  {
    boolean bool2 = false;
    AppMethodBeat.i(271463);
    p.k(paramActivity, "context");
    p.k(paramble, "resp");
    Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dXN().aSr()).intValue() == 1)
    {
      Log.i(TAG, "ignore all pre check");
      AppMethodBeat.o(271463);
      return true;
    }
    localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    int i = ((f)localObject).aHp().getInt(ar.a.VyF, 0);
    localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    boolean bool1;
    switch (((Number)com.tencent.mm.plugin.finder.storage.d.dXP().aSr()).intValue())
    {
    default: 
      if (!com.tencent.mm.ae.d.dr(i, 1))
      {
        bool1 = true;
        boolean bool3 = edp();
        localObject = aj.AGc;
        boolean bool4 = aj.eeu();
        localObject = paramble.SDj;
        if (localObject == null) {
          break label335;
        }
        localObject = ((FinderContact)localObject).authInfo;
        if (localObject == null) {
          break label335;
        }
        localObject = Integer.valueOf(((FinderAuthInfo)localObject).authIconType);
        label183:
        Log.i(TAG, "[preCheck] hasRealName:" + bool1 + " , hasBindPhone:" + bool3 + " isForeignUser:" + bool4 + ", authType:" + localObject);
        if (bool1) {
          break label350;
        }
        if (localObject != null) {
          break label341;
        }
        label246:
        if (localObject != null) {
          break label370;
        }
        label251:
        if (localObject != null) {
          break label474;
        }
        label256:
        bool1 = a((Context)paramActivity, paramble, Integer.valueOf(ADY), parama);
      }
      break;
    }
    for (;;)
    {
      Log.i(TAG, "[preCheck] result:".concat(String.valueOf(bool1)));
      AppMethodBeat.o(271463);
      return bool1;
      if (!com.tencent.mm.ae.d.dr(i, 1))
      {
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
      bool1 = true;
      break;
      bool1 = false;
      break;
      bool1 = false;
      break;
      label335:
      localObject = null;
      break label183;
      label341:
      if (((Integer)localObject).intValue() != 2) {
        break label246;
      }
      label350:
      bool1 = a((Context)paramActivity, paramble, Integer.valueOf(ADY), parama);
      continue;
      label370:
      if (((Integer)localObject).intValue() != 1) {
        break label251;
      }
      paramble = new f.a((Context)paramActivity);
      paramble.aR((CharSequence)paramActivity.getString(b.j.finder_post_real_name_dialog_title));
      paramble.bBl(paramActivity.getString(b.j.finder_post_real_name_dialog_content)).HL(true);
      paramble.bBp(paramActivity.getString(b.j.finder_post_real_name_dialog_positive));
      paramble.bBq(paramActivity.getString(b.j.finder_create_account_bindphone_dialog_negative_btn));
      paramble.b((f.c)new d(paramActivity, parama));
      paramble.show();
      bool1 = bool2;
      continue;
      label474:
      if (((Integer)localObject).intValue() != 0) {
        break label256;
      }
      paramble = new f.a((Context)paramActivity);
      paramble.aR((CharSequence)paramActivity.getString(b.j.finder_post_real_name_dialog_title_v2)).bBl(paramActivity.getString(b.j.finder_post_real_name_dialog_content_v2)).br(paramActivity.getString(b.j.finder_post_real_name_dialog_positive), paramActivity.getString(b.j.finder_post_real_name_dialog_positive_enterprise), paramActivity.getString(b.j.finder_create_account_bindphone_dialog_negative_btn));
      paramble.a((DialogInterface.OnClickListener)new e(paramActivity, parama), (DialogInterface.OnClickListener)new f(paramActivity, parama), (DialogInterface.OnClickListener)g.AEd).show();
      bool1 = bool2;
    }
  }
  
  private static boolean a(final Context paramContext, ble paramble, Integer paramInteger, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(271464);
    p.k(paramContext, "context");
    p.k(paramble, "prepareResp");
    Object localObject1;
    String str;
    Object localObject2;
    if (edp())
    {
      paramble = aj.AGc;
      if (aj.eeu())
      {
        paramble = h.aHG();
        p.j(paramble, "MMKernel.storage()");
        boolean bool = paramble.aHp().getBoolean(ar.a.Vzs, true);
        if (bool)
        {
          paramble = FinderBottomCustomDialogHelper.Companion;
          paramInteger = paramContext.getString(b.j.finder_create_account_dialog_title);
          parama = paramContext.getString(b.j.finder_create_account_dialog_foreign_content);
          p.j(parama, "context.getString(R.stri…t_dialog_foreign_content)");
          localObject1 = paramContext.getString(b.j.finder_create_account_dialog_foreign_prositive_btn);
          str = paramContext.getString(b.j.finder_create_account_bindphone_dialog_negative_btn);
          localObject2 = Boolean.FALSE;
          FinderBottomCustomDialogHelper.Companion.showConfirmTextDialog$default(paramble, paramContext, null, 0, paramInteger, parama, (String)localObject1, str, null, (DialogInterface.OnClickListener)w.a.AEa, (Boolean)localObject2, null, null, 3206, null);
        }
        Log.i(TAG, "[checkHasBindPhone] show argee save phone");
        if (!bool)
        {
          AppMethodBeat.o(271464);
          return true;
        }
        AppMethodBeat.o(271464);
        return false;
      }
      AppMethodBeat.o(271464);
      return true;
    }
    int i = ADX;
    if (paramInteger == null)
    {
      i = ADY;
      if (paramInteger != null) {
        break label350;
      }
      label198:
      paramble = "";
      label202:
      p.j(paramble, "when (formScene) {\n     … else -> \"\"\n            }");
      i = ADX;
      if (paramInteger != null) {
        break label370;
      }
      label218:
      i = ADY;
      if (paramInteger != null) {
        break label390;
      }
      label227:
      paramInteger = "";
      label231:
      p.j(paramInteger, "when (formScene) {\n     … else -> \"\"\n            }");
      localObject1 = aj.AGc;
      if (!aj.eeu()) {
        break label410;
      }
      paramInteger = new f.a(paramContext);
      paramInteger.bBl(paramble).HL(true);
      paramInteger.bBp(paramContext.getString(b.j.finder_create_account_bindphone_dialog_positive_btn));
      paramInteger.bBq(paramContext.getString(b.j.finder_create_account_bindphone_dialog_negative_btn));
      paramInteger.b((f.c)new b(parama, paramContext));
      paramInteger.show();
      Log.i(TAG, "[checkHasBindPhone] isUserWxForeign true");
    }
    for (;;)
    {
      AppMethodBeat.o(271464);
      return false;
      if (paramInteger.intValue() != i) {
        break;
      }
      paramble = paramContext.getString(b.j.finder_create_account_need_bind_phone_tips);
      break label202;
      label350:
      if (paramInteger.intValue() != i) {
        break label198;
      }
      paramble = paramContext.getString(b.j.finder_create_account_need_bind_phone_tips_post);
      break label202;
      label370:
      if (paramInteger.intValue() != i) {
        break label218;
      }
      paramInteger = paramContext.getString(b.j.finder_create_account_dialog_title);
      break label231;
      label390:
      if (paramInteger.intValue() != i) {
        break label227;
      }
      paramInteger = paramContext.getString(b.j.finder_create_account_dialog_title_post);
      break label231;
      label410:
      localObject1 = FinderBottomCustomDialogHelper.Companion;
      str = paramContext.getString(b.j.finder_create_account_bindphone_dialog_positive_btn);
      localObject2 = paramContext.getString(b.j.finder_create_account_bindphone_dialog_negative_btn);
      Boolean localBoolean = Boolean.FALSE;
      FinderBottomCustomDialogHelper.Companion.showConfirmTextDialog$default((FinderBottomCustomDialogHelper.Companion)localObject1, paramContext, null, 0, paramInteger, paramble, str, (String)localObject2, null, (DialogInterface.OnClickListener)new c(parama, paramContext), localBoolean, null, null, 3206, null);
      Log.i(TAG, "[checkHasBindPhone] isUserWxForeign false");
    }
  }
  
  private static boolean edp()
  {
    AppMethodBeat.i(271466);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    boolean bool;
    switch (((Number)com.tencent.mm.plugin.finder.storage.d.dXO().aSr()).intValue())
    {
    default: 
      localObject = aj.AGc;
      bool = aj.eew();
      AppMethodBeat.o(271466);
      return bool;
    case 0: 
      localObject = aj.AGc;
      bool = aj.eew();
      AppMethodBeat.o(271466);
      return bool;
    case 1: 
      AppMethodBeat.o(271466);
      return true;
    }
    AppMethodBeat.o(271466);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class b
    implements f.c
  {
    b(kotlin.g.a.a parama, Context paramContext) {}
    
    public final void g(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(278288);
      paramString = this.AEb;
      if (paramString != null) {
        paramString.invoke();
      }
      paramString = w.ADZ;
      w.fS(paramContext);
      AppMethodBeat.o(278288);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(kotlin.g.a.a parama, Context paramContext) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(285639);
      paramDialogInterface = this.AEb;
      if (paramDialogInterface != null) {
        paramDialogInterface.invoke();
      }
      paramDialogInterface = w.ADZ;
      w.fS(paramContext);
      AppMethodBeat.o(285639);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class d
    implements f.c
  {
    d(Activity paramActivity, kotlin.g.a.a parama) {}
    
    public final void g(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(285746);
      paramString = a.ACH;
      a.as(this.$context);
      paramString = parama;
      if (paramString != null)
      {
        paramString.invoke();
        AppMethodBeat.o(285746);
        return;
      }
      AppMethodBeat.o(285746);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(Activity paramActivity, kotlin.g.a.a parama) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(270588);
      paramDialogInterface = a.ACH;
      a.as(this.$context);
      paramDialogInterface = parama;
      if (paramDialogInterface != null)
      {
        paramDialogInterface.invoke();
        AppMethodBeat.o(270588);
        return;
      }
      AppMethodBeat.o(270588);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class f
    implements DialogInterface.OnClickListener
  {
    f(Activity paramActivity, kotlin.g.a.a parama) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(264352);
      paramDialogInterface = Uri.parse("pages/index/index.html").buildUpon();
      p.j(paramDialogInterface, "Uri.parse(\"pages/index/index.html\").buildUpon()");
      paramDialogInterface.appendQueryParameter("showdetail", "true");
      paramDialogInterface.appendQueryParameter("to_auth_company", "true");
      String str = paramDialogInterface.build().toString() + "&username=" + z.bdh();
      paramDialogInterface = a.ACH;
      Context localContext = (Context)this.$context;
      paramDialogInterface = str;
      if (str == null) {
        paramDialogInterface = "";
      }
      a.C(localContext, "gh_4ee148a6ecaa@app", paramDialogInterface);
      paramDialogInterface = parama;
      if (paramDialogInterface != null)
      {
        paramDialogInterface.invoke();
        AppMethodBeat.o(264352);
        return;
      }
      AppMethodBeat.o(264352);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class g
    implements DialogInterface.OnClickListener
  {
    public static final g AEd;
    
    static
    {
      AppMethodBeat.i(291530);
      AEd = new g();
      AppMethodBeat.o(291530);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.w
 * JD-Core Version:    0.7.0.1
 */