package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper;
import com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper.Companion;
import com.tencent.mm.plugin.findersdk.a.x;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.widget.a.g.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderPostPreCheckHelper;", "", "()V", "BINDER_PHONE_SCENE_CREATE_ACCDOUNT", "", "getBINDER_PHONE_SCENE_CREATE_ACCDOUNT", "()I", "BINDER_PHONE_SCENE_POST", "getBINDER_PHONE_SCENE_POST", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkHasBindPhone", "", "context", "Landroid/content/Context;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "formScene", "onGoBindPhoneListener", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)Z", "goToBindPhoneUI", "preCheck", "Landroid/app/Activity;", "resp", "onGoVertifyPage", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
{
  public static final ad Ghf;
  private static final int Ghg;
  private static final int Ghh;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(333589);
    Ghf = new ad();
    TAG = "FinderPostPreCheckHelper";
    Ghg = 1;
    Ghh = 2;
    AppMethodBeat.o(333589);
  }
  
  private static final void a(Activity paramActivity, kotlin.g.a.a parama, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(333547);
    s.u(paramActivity, "$context");
    paramDialogInterface = a.GfO;
    a.aK(paramActivity);
    if (parama != null) {
      parama.invoke();
    }
    AppMethodBeat.o(333547);
  }
  
  private static final void a(Activity paramActivity, kotlin.g.a.a parama, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(333538);
    s.u(paramActivity, "$context");
    paramString = a.GfO;
    a.aK(paramActivity);
    if (parama != null) {
      parama.invoke();
    }
    AppMethodBeat.o(333538);
  }
  
  private static final void a(kotlin.g.a.a parama, Context paramContext, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(333583);
    s.u(paramContext, "$context");
    if (parama != null) {
      parama.invoke();
    }
    hp(paramContext);
    AppMethodBeat.o(333583);
  }
  
  private static final void a(kotlin.g.a.a parama, Context paramContext, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(333577);
    s.u(paramContext, "$context");
    if (parama != null) {
      parama.invoke();
    }
    hp(paramContext);
    AppMethodBeat.o(333577);
  }
  
  public static boolean a(Activity paramActivity, bys parambys, kotlin.g.a.a<ah> parama)
  {
    Object localObject1 = null;
    boolean bool2 = false;
    AppMethodBeat.i(333491);
    s.u(paramActivity, "context");
    s.u(parambys, "resp");
    Object localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eWH().bmg()).intValue() == 1)
    {
      Log.i(TAG, "ignore all pre check");
      AppMethodBeat.o(333491);
      return true;
    }
    int i = h.baE().ban().getInt(at.a.adaB, 0);
    localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    boolean bool1;
    switch (((Number)com.tencent.mm.plugin.finder.storage.d.eWJ().bmg()).intValue())
    {
    default: 
      if (!com.tencent.mm.ae.d.ee(i, 1))
      {
        bool1 = true;
        boolean bool3 = fff();
        localObject2 = av.GiL;
        boolean bool4 = av.fgk();
        localObject2 = parambys.ZEd;
        if (localObject2 != null) {
          break label306;
        }
        label153:
        Log.i(TAG, "[preCheck] hasRealName:" + bool1 + " , hasBindPhone:" + bool3 + " isForeignUser:" + bool4 + ", authType:" + localObject1);
        if (bool1) {
          break label340;
        }
        if (localObject1 != null) {
          break label331;
        }
        label216:
        if (localObject1 != null) {
          break label360;
        }
        label221:
        if (localObject1 != null) {
          break label461;
        }
        label226:
        bool1 = a((Context)paramActivity, parambys, Integer.valueOf(Ghh), parama);
      }
      break;
    }
    for (;;)
    {
      Log.i(TAG, s.X("[preCheck] result:", Boolean.valueOf(bool1)));
      AppMethodBeat.o(333491);
      return bool1;
      if (!com.tencent.mm.ae.d.ee(i, 1))
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
      label306:
      localObject2 = ((FinderContact)localObject2).authInfo;
      if (localObject2 == null) {
        break label153;
      }
      localObject1 = Integer.valueOf(((FinderAuthInfo)localObject2).authIconType);
      break label153;
      label331:
      if (((Integer)localObject1).intValue() != 2) {
        break label216;
      }
      label340:
      bool1 = a((Context)paramActivity, parambys, Integer.valueOf(Ghh), parama);
      continue;
      label360:
      if (((Integer)localObject1).intValue() != 1) {
        break label221;
      }
      parambys = new g.a((Context)paramActivity);
      parambys.bf((CharSequence)paramActivity.getString(e.h.finder_post_real_name_dialog_title));
      parambys.bDE(paramActivity.getString(e.h.finder_post_real_name_dialog_content)).NF(true);
      parambys.bDI(paramActivity.getString(e.h.finder_post_real_name_dialog_positive));
      parambys.bDJ(paramActivity.getString(e.h.finder_create_account_bindphone_dialog_negative_btn));
      parambys.b(new ad..ExternalSyntheticLambda5(paramActivity, parama));
      parambys.show();
      bool1 = bool2;
      continue;
      label461:
      if (((Integer)localObject1).intValue() != 0) {
        break label226;
      }
      parambys = new g.a((Context)paramActivity);
      parambys.bf((CharSequence)paramActivity.getString(e.h.finder_post_real_name_dialog_title_v2)).bDE(paramActivity.getString(e.h.finder_post_real_name_dialog_content_v2)).bO(paramActivity.getString(e.h.finder_post_real_name_dialog_positive), paramActivity.getString(e.h.finder_post_real_name_dialog_positive_enterprise), paramActivity.getString(e.h.finder_create_account_bindphone_dialog_negative_btn));
      parambys.b(new ad..ExternalSyntheticLambda0(paramActivity, parama), new ad..ExternalSyntheticLambda1(paramActivity, parama), ad..ExternalSyntheticLambda4.INSTANCE).show();
      bool1 = bool2;
    }
  }
  
  private static boolean a(Context paramContext, bys parambys, Integer paramInteger, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(333510);
    s.u(paramContext, "context");
    s.u(parambys, "prepareResp");
    parambys = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eWH().bmg()).intValue() == 1)
    {
      Log.i(TAG, "ignore all pre check");
      AppMethodBeat.o(333510);
      return true;
    }
    Object localObject;
    if (fff())
    {
      parambys = av.GiL;
      if (av.fgk())
      {
        boolean bool = h.baE().ban().getBoolean(at.a.adbx, true);
        if (bool)
        {
          parambys = FinderBottomCustomDialogHelper.Companion;
          paramInteger = paramContext.getString(e.h.finder_create_account_dialog_title);
          parama = paramContext.getString(e.h.finder_create_account_dialog_foreign_content);
          localObject = paramContext.getString(e.h.finder_create_account_dialog_foreign_prositive_btn);
          String str = paramContext.getString(e.h.finder_create_account_bindphone_dialog_negative_btn);
          ad..ExternalSyntheticLambda3 localExternalSyntheticLambda3 = ad..ExternalSyntheticLambda3.INSTANCE;
          s.s(parama, "getString(R.string.finde…t_dialog_foreign_content)");
          FinderBottomCustomDialogHelper.Companion.showConfirmTextDialog$default(parambys, paramContext, null, 0, paramInteger, parama, (String)localObject, str, null, localExternalSyntheticLambda3, Boolean.FALSE, null, null, 3206, null);
        }
        Log.i(TAG, "[checkHasBindPhone] show argee save phone");
        if (!bool)
        {
          AppMethodBeat.o(333510);
          return true;
        }
        AppMethodBeat.o(333510);
        return false;
      }
      AppMethodBeat.o(333510);
      return true;
    }
    int i = Ghg;
    if (paramInteger == null)
    {
      i = Ghh;
      if (paramInteger != null) {
        break label372;
      }
      label223:
      parambys = "";
      label227:
      s.s(parambys, "when (formScene) {\n     … else -> \"\"\n            }");
      i = Ghg;
      if (paramInteger != null) {
        break label392;
      }
      label243:
      i = Ghh;
      if (paramInteger != null) {
        break label412;
      }
      label252:
      paramInteger = "";
      label256:
      s.s(paramInteger, "when (formScene) {\n     … else -> \"\"\n            }");
      localObject = av.GiL;
      if (!av.fgk()) {
        break label432;
      }
      paramInteger = new g.a(paramContext);
      paramInteger.bDE(parambys).NF(true);
      paramInteger.bDI(paramContext.getString(e.h.finder_create_account_bindphone_dialog_positive_btn));
      paramInteger.bDJ(paramContext.getString(e.h.finder_create_account_bindphone_dialog_negative_btn));
      paramInteger.b(new ad..ExternalSyntheticLambda6(parama, paramContext));
      paramInteger.show();
      Log.i(TAG, "[checkHasBindPhone] isUserWxForeign true");
    }
    for (;;)
    {
      AppMethodBeat.o(333510);
      return false;
      if (paramInteger.intValue() != i) {
        break;
      }
      parambys = paramContext.getString(e.h.finder_create_account_need_bind_phone_tips);
      break label227;
      label372:
      if (paramInteger.intValue() != i) {
        break label223;
      }
      parambys = paramContext.getString(e.h.finder_create_account_need_bind_phone_tips_post);
      break label227;
      label392:
      if (paramInteger.intValue() != i) {
        break label243;
      }
      paramInteger = paramContext.getString(e.h.finder_create_account_dialog_title);
      break label256;
      label412:
      if (paramInteger.intValue() != i) {
        break label252;
      }
      paramInteger = paramContext.getString(e.h.finder_create_account_dialog_title_post);
      break label256;
      label432:
      FinderBottomCustomDialogHelper.Companion.showConfirmTextDialog$default(FinderBottomCustomDialogHelper.Companion, paramContext, null, 0, paramInteger, parambys, paramContext.getString(e.h.finder_create_account_bindphone_dialog_positive_btn), paramContext.getString(e.h.finder_create_account_bindphone_dialog_negative_btn), null, new ad..ExternalSyntheticLambda2(parama, paramContext), Boolean.FALSE, null, null, 3206, null);
      Log.i(TAG, "[checkHasBindPhone] isUserWxForeign false");
    }
  }
  
  private static final void b(Activity paramActivity, kotlin.g.a.a parama, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(333557);
    s.u(paramActivity, "$context");
    paramDialogInterface = Uri.parse("pages/index/index.html").buildUpon();
    s.s(paramDialogInterface, "parse(\"pages/index/index.html\").buildUpon()");
    paramDialogInterface.appendQueryParameter("showdetail", "true");
    paramDialogInterface.appendQueryParameter("to_auth_company", "true");
    paramDialogInterface = paramDialogInterface.build() + "&username=" + z.bAW();
    Object localObject = a.GfO;
    localObject = (Context)paramActivity;
    paramActivity = paramDialogInterface;
    if (paramDialogInterface == null) {
      paramActivity = "";
    }
    a.C((Context)localObject, "gh_4ee148a6ecaa@app", paramActivity);
    if (parama != null) {
      parama.invoke();
    }
    AppMethodBeat.o(333557);
  }
  
  private static boolean fff()
  {
    AppMethodBeat.i(333522);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    boolean bool;
    switch (((Number)com.tencent.mm.plugin.finder.storage.d.eWI().bmg()).intValue())
    {
    default: 
      localObject = av.GiL;
      bool = av.fgm();
      AppMethodBeat.o(333522);
      return bool;
    case 0: 
      localObject = av.GiL;
      bool = av.fgm();
      AppMethodBeat.o(333522);
      return bool;
    case 1: 
      AppMethodBeat.o(333522);
      return true;
    }
    AppMethodBeat.o(333522);
    return false;
  }
  
  private static void hp(Context paramContext)
  {
    AppMethodBeat.i(333529);
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, BindMContactIntroUI.class);
    MMWizardActivity.aQ(paramContext, localIntent);
    AppMethodBeat.o(333529);
  }
  
  private static final void y(DialogInterface paramDialogInterface, int paramInt) {}
  
  private static final void z(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(333570);
    paramDialogInterface = h.ax(x.class);
    s.s(paramDialogInterface, "service(IFinderAgreeSavePhoneService::class.java)");
    ((x)paramDialogInterface).r(Boolean.FALSE);
    AppMethodBeat.o(333570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ad
 * JD-Core Version:    0.7.0.1
 */