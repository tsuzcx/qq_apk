package com.tencent.mm.msgsubscription.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.util.c;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/presenter/WxaSubscribeMsgSettingPagePresenter;", "Lcom/tencent/mm/msgsubscription/presenter/BaseSubscribeMsgSettingPagePresenter;", "()V", "activity", "Landroid/app/Activity;", "changed", "", "subscribeMsgSettingData", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "dispatchLoadDataResult", "", "l", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "getCheckBoxState", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "loadData", "bizUsername", "", "onActivityCreated", "onFinish", "onSubscribeMsgItemCheckBoxChanged", "itemChanged", "check", "onSubscribeSwitchChanged", "on", "Companion", "plugin-comm_release"})
public final class d
  extends a
{
  public static final a iBb;
  private Activity activity;
  private boolean bGk;
  private SubscribeMsgSettingData iBa;
  
  static
  {
    AppMethodBeat.i(149587);
    iBb = new a((byte)0);
    AppMethodBeat.o(149587);
  }
  
  private static void a(b.a parama, SubscribeMsgSettingData paramSubscribeMsgSettingData)
  {
    AppMethodBeat.i(149582);
    if (paramSubscribeMsgSettingData == null)
    {
      parama.onError();
      AppMethodBeat.o(149582);
      return;
    }
    parama.a(paramSubscribeMsgSettingData);
    AppMethodBeat.o(149582);
  }
  
  public final void a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, boolean paramBoolean)
  {
    AppMethodBeat.i(149584);
    p.h(paramSubscribeMsgTmpItem, "itemChanged");
    this.bGk = true;
    Object localObject = this.iBa;
    if (localObject == null) {
      p.gfZ();
    }
    localObject = ((SubscribeMsgSettingData)localObject).hJj.iterator();
    while (((Iterator)localObject).hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)((Iterator)localObject).next();
      if (TextUtils.equals((CharSequence)paramSubscribeMsgTmpItem.hAT, (CharSequence)localSubscribeMsgTmpItem.hAT))
      {
        if (paramBoolean) {}
        for (int i = 1;; i = 0)
        {
          localSubscribeMsgTmpItem.iAs = i;
          AppMethodBeat.o(149584);
          return;
        }
      }
    }
    AppMethodBeat.o(149584);
  }
  
  public final void a(String paramString, final b.a parama)
  {
    AppMethodBeat.i(149581);
    p.h(paramString, "bizUsername");
    p.h(parama, "l");
    Object localObject = this.activity;
    if (localObject == null) {
      p.bcb("activity");
    }
    this.iBa = ((SubscribeMsgSettingData)((Activity)localObject).getIntent().getParcelableExtra("key_biz_data"));
    if (this.iBa == null)
    {
      localObject = c.iEf;
      c.c(paramString, (b)new b(this, parama));
      AppMethodBeat.o(149581);
      return;
    }
    a(parama, this.iBa);
    AppMethodBeat.o(149581);
  }
  
  public final boolean a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem)
  {
    AppMethodBeat.i(149586);
    p.h(paramSubscribeMsgTmpItem, "item");
    if (paramSubscribeMsgTmpItem.iAs == 1)
    {
      AppMethodBeat.o(149586);
      return true;
    }
    AppMethodBeat.o(149586);
    return false;
  }
  
  public final void eJ(boolean paramBoolean)
  {
    this.bGk = true;
    SubscribeMsgSettingData localSubscribeMsgSettingData = this.iBa;
    if (localSubscribeMsgSettingData != null) {
      localSubscribeMsgSettingData.hSy = paramBoolean;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity)
  {
    AppMethodBeat.i(149580);
    p.h(paramActivity, "activity");
    super.onActivityCreated(paramActivity);
    this.activity = paramActivity;
    AppMethodBeat.o(149580);
  }
  
  public final void y(Activity paramActivity)
  {
    AppMethodBeat.i(149585);
    p.h(paramActivity, "activity");
    if ((this.bGk) && (this.iBa != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_biz_data", (Parcelable)this.iBa);
      paramActivity.setResult(-1, localIntent);
    }
    AppMethodBeat.o(149585);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/presenter/WxaSubscribeMsgSettingPagePresenter$Companion;", "", "()V", "TAG", "", "plugin-comm_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "invoke"})
  static final class b
    extends q
    implements b<SubscribeMsgSettingData, z>
  {
    b(d paramd, b.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.presenter.d
 * JD-Core Version:    0.7.0.1
 */