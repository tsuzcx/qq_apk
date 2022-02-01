package com.tencent.mm.msgsubscription.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.ui.AppBrandAuthorizeSubscribeMsgDetailUI;
import com.tencent.mm.msgsubscription.ui.g;
import com.tencent.mm.msgsubscription.ui.g.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/presenter/WxaSubscribeMsgSettingPagePresenter;", "Lcom/tencent/mm/msgsubscription/presenter/BaseSubscribeMsgSettingPagePresenter;", "()V", "REQUEST_CODE_TO_DETAIL", "", "activity", "Landroid/app/Activity;", "changed", "", "subscribeMsgSettingData", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "createAdapter", "Lcom/tencent/mm/msgsubscription/ui/BaseSubscribeMsgListAdapter;", "Lcom/tencent/mm/ui/MMActivity;", "dispatchLoadDataResult", "", "l", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "getCheckBoxState", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "goDetailUI", "position", "loadData", "bizUsername", "", "onActivityCreated", "onFinish", "onSubscribeMsgItemCheckBoxChanged", "itemChanged", "check", "onSubscribeMsgItemInfoClick", "view", "Landroid/view/View;", "onSubscribeSwitchChanged", "on", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends a
{
  public static final d.a pjC;
  private Activity activity;
  private boolean djJ;
  private final int pjD = 1;
  private SubscribeMsgSettingData pjE;
  
  static
  {
    AppMethodBeat.i(149587);
    pjC = new d.a((byte)0);
    AppMethodBeat.o(149587);
  }
  
  private static void a(b.a parama, SubscribeMsgSettingData paramSubscribeMsgSettingData)
  {
    AppMethodBeat.i(149582);
    if (paramSubscribeMsgSettingData == null)
    {
      parama.atR();
      AppMethodBeat.o(149582);
      return;
    }
    parama.a(paramSubscribeMsgSettingData);
    AppMethodBeat.o(149582);
  }
  
  private static final void a(d paramd, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(236513);
    s.u(paramd, "this$0");
    SubscribeMsgTmpItem localSubscribeMsgTmpItem1;
    SubscribeMsgTmpItem localSubscribeMsgTmpItem2;
    if ((paramInt2 == paramd.pjD) && (paramInt3 == -1))
    {
      localSubscribeMsgTmpItem1 = (SubscribeMsgTmpItem)paramIntent.getParcelableExtra("key_data");
      boolean bool = paramIntent.getBooleanExtra("key_status_subscribed", false);
      if (localSubscribeMsgTmpItem1 == null)
      {
        AppMethodBeat.o(236513);
        return;
      }
      s.u(localSubscribeMsgTmpItem1, "itemChanged");
      paramd.djJ = true;
      paramIntent = paramd.pjE;
      s.checkNotNull(paramIntent);
      paramIntent = paramIntent.bMQ.iterator();
      while (paramIntent.hasNext())
      {
        localSubscribeMsgTmpItem2 = (SubscribeMsgTmpItem)paramIntent.next();
        if (TextUtils.equals((CharSequence)localSubscribeMsgTmpItem1.nSg, (CharSequence)localSubscribeMsgTmpItem2.nSg)) {
          if (!bool) {
            break label192;
          }
        }
      }
    }
    label192:
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      localSubscribeMsgTmpItem2.phT = paramInt2;
      localSubscribeMsgTmpItem2.phu = localSubscribeMsgTmpItem1.phu;
      localSubscribeMsgTmpItem2.pib = localSubscribeMsgTmpItem1.pib;
      paramd.bQc().xq(paramInt1);
      Log.i("MicroMsg.WxaSubscribeMsgSettingPagePresenter", "goDetailUI  mmSetOnActivityResultCallback");
      AppMethodBeat.o(236513);
      return;
    }
  }
  
  public static boolean a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem)
  {
    AppMethodBeat.i(149586);
    s.u(paramSubscribeMsgTmpItem, "item");
    if (paramSubscribeMsgTmpItem.phT == 1)
    {
      AppMethodBeat.o(149586);
      return true;
    }
    AppMethodBeat.o(149586);
    return false;
  }
  
  public final void A(Activity paramActivity)
  {
    AppMethodBeat.i(149585);
    s.u(paramActivity, "activity");
    if ((this.djJ) && (this.pjE != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_biz_data", (Parcelable)this.pjE);
      paramActivity.setResult(-1, localIntent);
    }
    AppMethodBeat.o(149585);
  }
  
  public final void a(MMActivity paramMMActivity, SubscribeMsgTmpItem paramSubscribeMsgTmpItem, int paramInt)
  {
    AppMethodBeat.i(236562);
    s.u(paramMMActivity, "activity");
    s.u(paramSubscribeMsgTmpItem, "item");
    paramMMActivity.mmSetOnActivityResultCallback(new d..ExternalSyntheticLambda0(this, paramInt));
    Intent localIntent = new Intent((Context)paramMMActivity, AppBrandAuthorizeSubscribeMsgDetailUI.class);
    localIntent.putExtra("key_data", (Parcelable)paramSubscribeMsgTmpItem);
    localIntent.putExtra("key_status_subscribed", a(paramSubscribeMsgTmpItem));
    com.tencent.mm.br.c.d((Context)paramMMActivity, "com.tencent.mm.msgsubscription.ui.AppBrandAuthorizeSubscribeMsgDetailUI", localIntent, this.pjD);
    AppMethodBeat.o(236562);
  }
  
  public final void a(String paramString, final b.a parama)
  {
    AppMethodBeat.i(149581);
    s.u(paramString, "bizUsername");
    s.u(parama, "l");
    Activity localActivity = this.activity;
    Object localObject = localActivity;
    if (localActivity == null)
    {
      s.bIx("activity");
      localObject = null;
    }
    this.pjE = ((SubscribeMsgSettingData)((Activity)localObject).getIntent().getParcelableExtra("key_biz_data"));
    if (this.pjE == null)
    {
      localObject = com.tencent.mm.msgsubscription.util.d.pmU;
      com.tencent.mm.msgsubscription.util.d.c(paramString, (b)new c(this, parama));
      AppMethodBeat.o(149581);
      return;
    }
    a(parama, this.pjE);
    AppMethodBeat.o(149581);
  }
  
  public final com.tencent.mm.msgsubscription.ui.a<?> b(final MMActivity paramMMActivity)
  {
    AppMethodBeat.i(236568);
    s.u(paramMMActivity, "activity");
    paramMMActivity = (com.tencent.mm.msgsubscription.ui.a)new g((Context)paramMMActivity, (g.c)new b(this, paramMMActivity));
    AppMethodBeat.o(236568);
    return paramMMActivity;
  }
  
  public final void he(boolean paramBoolean)
  {
    this.djJ = true;
    SubscribeMsgSettingData localSubscribeMsgSettingData = this.pjE;
    if (localSubscribeMsgSettingData != null) {
      localSubscribeMsgSettingData.oyB = paramBoolean;
    }
  }
  
  public final void z(Activity paramActivity)
  {
    AppMethodBeat.i(149580);
    s.u(paramActivity, "activity");
    super.z(paramActivity);
    this.activity = paramActivity;
    AppMethodBeat.o(149580);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/presenter/WxaSubscribeMsgSettingPagePresenter$createAdapter$1", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgSecondaryMenuListAdapter$SubscribeMsgSecondaryMenuListener;", "getSubscribeState", "", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "onClick", "", "position", "", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements g.c
  {
    b(d paramd, MMActivity paramMMActivity) {}
    
    public final void a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, int paramInt)
    {
      AppMethodBeat.i(236498);
      s.u(paramSubscribeMsgTmpItem, "item");
      this.pjF.a(paramMMActivity, paramSubscribeMsgTmpItem, paramInt);
      AppMethodBeat.o(236498);
    }
    
    public final boolean c(SubscribeMsgTmpItem paramSubscribeMsgTmpItem)
    {
      AppMethodBeat.i(236504);
      s.u(paramSubscribeMsgTmpItem, "item");
      boolean bool = d.a(paramSubscribeMsgTmpItem);
      AppMethodBeat.o(236504);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<SubscribeMsgSettingData, ah>
  {
    c(d paramd, b.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.presenter.d
 * JD-Core Version:    0.7.0.1
 */