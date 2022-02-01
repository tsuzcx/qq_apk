package com.tencent.mm.openim.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.openim.api.j;
import com.tencent.mm.openim.e.k;
import com.tencent.mm.openim.e.l;
import com.tencent.mm.openim.model.IOpenIMKefuConfirmController;
import com.tencent.mm.plugin.comm.c.b;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.y;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/ui/OpenIMKefuConfirmFullUIModelImpl;", "Lcom/tencent/mm/openim/ui/OpenIMKefuConfirmBaseUIModel;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "antispamTips", "Landroid/widget/TextView;", "closeButton", "confirmButton", "confirmContainer", "Landroid/view/ViewGroup;", "confirmDesc", "confirmTitle", "kfAvatar", "Landroid/widget/ImageView;", "kfContact", "Lcom/tencent/mm/openim/api/IOpenIMKefuContact;", "kfDescWording", "kfNickname", "animateShowConfirmUI", "", "fillAntispamTips", "", "confirmData", "Lcom/tencent/mm/openim/api/OpenIMKefuGetContactResult;", "fillOpenIMDescWording", "contact", "init", "onConfirm", "onConfirmCancel", "onConfirmOpFailed", "onConfirmOpSuccess", "onCreate", "confirmController", "Lcom/tencent/mm/openim/model/IOpenIMKefuConfirmController;", "onNotifyChange", "event", "", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "release", "showConfirmUI", "confirmType", "", "confirmPageType", "updateOpenIMDescWording", "openImAppId", "wording", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends b
  implements MStorage.IOnStorageChange
{
  public static final d.a pue;
  private final ViewGroup puf;
  private final TextView pug;
  private final TextView puh;
  private final TextView pui;
  private final TextView puj;
  private final ImageView puk;
  private final TextView pul;
  private final TextView pum;
  private final TextView pun;
  private com.tencent.mm.openim.api.a puo;
  
  static
  {
    AppMethodBeat.i(235931);
    pue = new d.a((byte)0);
    AppMethodBeat.o(235931);
  }
  
  public d(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(235901);
    C(paramActivity);
    View localView = paramActivity.findViewById(c.e.confirm_container);
    s.s(localView, "context.findViewById(R.id.confirm_container)");
    this.puf = ((ViewGroup)localView);
    this.puf.setVisibility(0);
    localView = paramActivity.findViewById(c.e.confirm_title);
    s.s(localView, "context.findViewById(R.id.confirm_title)");
    this.pug = ((TextView)localView);
    localView = paramActivity.findViewById(c.e.confirm_desc);
    s.s(localView, "context.findViewById(R.id.confirm_desc)");
    this.puh = ((TextView)localView);
    localView = paramActivity.findViewById(c.e.confirm_button);
    s.s(localView, "context.findViewById(R.id.confirm_button)");
    this.pui = ((TextView)localView);
    localView = paramActivity.findViewById(c.e.close_btn);
    s.s(localView, "context.findViewById(R.id.close_btn)");
    this.puj = ((TextView)localView);
    localView = paramActivity.findViewById(c.e.kf_avatar);
    s.s(localView, "context.findViewById(R.id.kf_avatar)");
    this.puk = ((ImageView)localView);
    localView = paramActivity.findViewById(c.e.kf_nickname);
    s.s(localView, "context.findViewById(R.id.kf_nickname)");
    this.pul = ((TextView)localView);
    localView = paramActivity.findViewById(c.e.kf_desc_wording);
    s.s(localView, "context.findViewById(R.id.kf_desc_wording)");
    this.pum = ((TextView)localView);
    paramActivity = paramActivity.findViewById(c.e.kf_antispam_tips);
    s.s(paramActivity, "context.findViewById(R.id.kf_antispam_tips)");
    this.pun = ((TextView)paramActivity);
    ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getWordingInfoStg().add((MStorage.IOnStorageChange)this);
    aw.a((Paint)this.pug.getPaint(), 0.8F);
    aw.a((Paint)this.pui.getPaint(), 0.8F);
    this.puj.setOnClickListener(new d..ExternalSyntheticLambda0(this));
    this.puh.setVisibility(8);
    this.puk.setVisibility(8);
    this.pul.setVisibility(8);
    this.pui.setEnabled(false);
    AppMethodBeat.o(235901);
  }
  
  private static final void a(d paramd)
  {
    AppMethodBeat.i(235924);
    s.u(paramd, "this$0");
    paramd.bSn();
    AppMethodBeat.o(235924);
  }
  
  private static final void a(d paramd, int paramInt, View paramView)
  {
    AppMethodBeat.i(235919);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/openim/ui/OpenIMKefuConfirmFullUIModelImpl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    paramd = paramd.ptX;
    if (paramd != null) {
      paramd.xH(paramInt);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/openim/ui/OpenIMKefuConfirmFullUIModelImpl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(235919);
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(235911);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/openim/ui/OpenIMKefuConfirmFullUIModelImpl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    paramd.bSt();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/openim/ui/OpenIMKefuConfirmFullUIModelImpl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(235911);
  }
  
  private final void cf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(235907);
    CharSequence localCharSequence = (CharSequence)paramString2;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label82;
      }
      if (!s.p("3552365301", paramString1)) {
        break label111;
      }
    }
    label82:
    label111:
    for (paramString1 = s.X("@", paramString2);; paramString1 = paramString2)
    {
      this.pum.setText((CharSequence)paramString1);
      this.pum.setVisibility(0);
      AppMethodBeat.o(235907);
      return;
      i = 0;
      break;
      this.pum.setText((CharSequence)"");
      this.pum.setVisibility(8);
      AppMethodBeat.o(235907);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, j paramj)
  {
    AppMethodBeat.i(235965);
    s.u(paramj, "confirmData");
    super.a(paramInt1, paramInt2, paramj);
    this.puo = paramj.prp;
    com.tencent.mm.openim.api.a locala = paramj.prp;
    this.pui.setOnClickListener(new d..ExternalSyntheticLambda1(this, paramInt1));
    this.puh.setVisibility(0);
    this.puk.setVisibility(0);
    this.pul.setVisibility(0);
    this.pui.setEnabled(true);
    TextView localTextView = this.pul;
    Object localObject;
    if (locala == null)
    {
      localObject = (CharSequence)"";
      localTextView.setText((CharSequence)localObject);
      s.s(locala, "contact");
      localObject = ((e)com.tencent.mm.kernel.h.ax(e.class)).cc(locala.bRR(), locala.bRS());
      cf(locala.bRR(), (String)localObject);
      localObject = (CharSequence)paramj.prr;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label376;
      }
      paramInt1 = 1;
      label185:
      if (paramInt1 != 0) {
        break label381;
      }
      this.pun.setText((CharSequence)paramj.prr);
      this.pun.setVisibility(0);
      label211:
      a.b.g(this.puk, locala.getUsername());
      paramj = this.puf;
      paramj.setVisibility(0);
      localObject = this.ptX;
      if (localObject != null) {
        break label393;
      }
      paramInt1 = -1;
      label248:
      switch (paramInt1)
      {
      }
    }
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      if (paramInt1 == 0) {
        break label409;
      }
      paramj.setAlpha(0.0F);
      paramj = paramj.animate();
      if (paramj == null) {
        break label414;
      }
      paramj = paramj.alpha(1.0F);
      if (paramj == null) {
        break label414;
      }
      paramj = paramj.setDuration(200L);
      if (paramj == null) {
        break label414;
      }
      paramj = paramj.setStartDelay(100L);
      if (paramj == null) {
        break label414;
      }
      paramj.start();
      AppMethodBeat.o(235965);
      return;
      localObject = locala.getNickname();
      if (localObject == null)
      {
        localObject = (CharSequence)"";
        break;
      }
      localObject = (CharSequence)localObject;
      break;
      label376:
      paramInt1 = 0;
      break label185;
      label381:
      this.pun.setVisibility(8);
      break label211;
      label393:
      paramInt1 = ((IOpenIMKefuConfirmController)localObject).getScene();
      break label248;
    }
    label409:
    paramj.setAlpha(1.0F);
    label414:
    AppMethodBeat.o(235965);
  }
  
  public final void a(IOpenIMKefuConfirmController paramIOpenIMKefuConfirmController)
  {
    AppMethodBeat.i(235945);
    s.u(paramIOpenIMKefuConfirmController, "confirmController");
    super.a(paramIOpenIMKefuConfirmController);
    this.puf.setVisibility(0);
    if ((getContext() instanceof MMActivity))
    {
      paramIOpenIMKefuConfirmController = getContext();
      if (paramIOpenIMKefuConfirmController == null)
      {
        paramIOpenIMKefuConfirmController = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(235945);
        throw paramIOpenIMKefuConfirmController;
      }
      paramIOpenIMKefuConfirmController = ((MMActivity)paramIOpenIMKefuConfirmController).getController();
      Activity localActivity = getContext();
      s.checkNotNull(localActivity);
      paramIOpenIMKefuConfirmController.setStatusBarColor(localActivity.getResources().getColor(c.b.white));
    }
    AppMethodBeat.o(235945);
  }
  
  public final void bSn()
  {
    AppMethodBeat.i(235977);
    com.tencent.threadpool.h.ahAA.o(new d..ExternalSyntheticLambda2(this), 400L);
    AppMethodBeat.o(235977);
  }
  
  public final void bSs()
  {
    AppMethodBeat.i(235970);
    super.bSs();
    AppMethodBeat.o(235970);
  }
  
  public final void bSu()
  {
    int i = 1;
    AppMethodBeat.i(235987);
    IOpenIMKefuConfirmController localIOpenIMKefuConfirmController = this.ptX;
    if ((localIOpenIMKefuConfirmController != null) && (localIOpenIMKefuConfirmController.bSh() == true)) {}
    for (;;)
    {
      if (i != 0) {
        super.bSu();
      }
      AppMethodBeat.o(235987);
      return;
      i = 0;
    }
  }
  
  public final void bSv()
  {
    int i = 1;
    AppMethodBeat.i(235992);
    IOpenIMKefuConfirmController localIOpenIMKefuConfirmController = this.ptX;
    if ((localIOpenIMKefuConfirmController != null) && (localIOpenIMKefuConfirmController.bSg() == true)) {}
    for (;;)
    {
      if (i != 0) {
        super.bSv();
      }
      AppMethodBeat.o(235992);
      return;
      i = 0;
    }
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    Object localObject = null;
    AppMethodBeat.i(235956);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(235956);
      return;
    }
    if (paramMStorageEventData == null)
    {
      AppMethodBeat.o(235956);
      return;
    }
    String str;
    if ((paramMStorageEventData.obj instanceof k))
    {
      paramString = paramMStorageEventData.obj;
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.openim.storage.OpenIMWordingInfo");
        AppMethodBeat.o(235956);
        throw paramString;
      }
      paramMStorageEventData = (k)paramString;
      str = paramMStorageEventData.field_appid;
      paramString = this.puo;
      if (paramString != null) {
        break label205;
      }
      paramString = null;
      if (s.p(str, paramString))
      {
        str = paramMStorageEventData.field_wordingId;
        paramString = this.puo;
        if (paramString != null) {
          break label215;
        }
      }
    }
    label205:
    label215:
    for (paramString = localObject;; paramString = paramString.bRS())
    {
      if (s.p(str, paramString))
      {
        Log.i("MicroMsg.OpenIMKefuConfirmFullUIModelImpl", "onNotifyChange openImAppId: %s, wordingId: %s, wording: %s", new Object[] { paramMStorageEventData.field_appid, paramMStorageEventData.field_wordingId, paramMStorageEventData.field_wording });
        cf(paramMStorageEventData.field_appid, paramMStorageEventData.field_wording);
      }
      AppMethodBeat.o(235956);
      return;
      paramString = paramString.bRR();
      break;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(235950);
    super.release();
    ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getWordingInfoStg().remove((MStorage.IOnStorageChange)this);
    AppMethodBeat.o(235950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.openim.ui.d
 * JD-Core Version:    0.7.0.1
 */