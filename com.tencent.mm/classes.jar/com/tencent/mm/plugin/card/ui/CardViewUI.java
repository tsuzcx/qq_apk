package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.k;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cgd;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

public class CardViewUI
  extends CardBaseUI
{
  private int aoW;
  private int ejF;
  private String fhC;
  private LinkedList<ph> ksE;
  private int kua;
  private String kyo;
  private View kyp;
  private String mAppId;
  
  public CardViewUI()
  {
    AppMethodBeat.i(88671);
    this.aoW = 1;
    this.ksE = new LinkedList();
    this.fhC = "";
    this.mAppId = "";
    AppMethodBeat.o(88671);
  }
  
  public final BaseAdapter Kp()
  {
    AppMethodBeat.i(88676);
    if (this.aoW == 0)
    {
      localObject = new g(getApplicationContext());
      AppMethodBeat.o(88676);
      return localObject;
    }
    Object localObject = super.Kp();
    AppMethodBeat.o(88676);
    return localObject;
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(88680);
    if (this.aoW == 0)
    {
      am.bci().kkN = ((CardInfo)paramb);
      Intent localIntent = new Intent(this, CardDetailUI.class);
      localIntent.putExtra("key_card_id", ((CardInfo)paramb).field_card_id);
      localIntent.putExtra("key_from_scene", 51);
      localIntent.putExtra("key_from_appbrand_type", this.kua);
      startActivity(localIntent);
      AppMethodBeat.o(88680);
      return;
    }
    super.a(paramb, paramInt);
    AppMethodBeat.o(88680);
  }
  
  public final void a(CardInfo paramCardInfo)
  {
    AppMethodBeat.i(88679);
    if (this.aoW == 1)
    {
      this.kkN = paramCardInfo;
      l(this.kyo, 1, true);
      AppMethodBeat.o(88679);
      return;
    }
    super.a(paramCardInfo);
    if (this.kkN != null) {
      h.qsU.e(11582, new Object[] { "OperGift", Integer.valueOf(4), Integer.valueOf(this.kkN.bbd().iFL), this.kkN.field_card_tp_id, this.kkN.field_card_id, this.kyo });
    }
    AppMethodBeat.o(88679);
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(88678);
    if (this.aoW == 1)
    {
      a((CardInfo)paramb);
      AppMethodBeat.o(88678);
      return;
    }
    super.b(paramb, paramInt);
    AppMethodBeat.o(88678);
  }
  
  public final boolean baA()
  {
    AppMethodBeat.i(88677);
    if (this.aoW == 1)
    {
      AppMethodBeat.o(88677);
      return false;
    }
    boolean bool = super.baA();
    AppMethodBeat.o(88677);
    return bool;
  }
  
  public final void bax()
  {
    AppMethodBeat.i(88675);
    int i;
    if (this.aoW == 0)
    {
      setMMTitle(2131298084);
      com.tencent.mm.kernel.g.RK().eHt.a(699, this);
      if (this.aoW != 0) {
        break label156;
      }
      fV(true);
      Object localObject = new cgd();
      ((cgd)localObject).xQS = this.fhC;
      ab.i("MicroMsg.CardViewUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { this.fhC });
      localObject = new t(this.ksE, (cgd)localObject, this.ejF);
      com.tencent.mm.kernel.g.RK().eHt.a((m)localObject, 0);
      i = 2131297854;
    }
    for (;;)
    {
      findViewById(2131822246).setVisibility(8);
      ((TextView)findViewById(2131821982)).setText(i);
      AppMethodBeat.o(88675);
      return;
      if (this.aoW != 1) {
        break;
      }
      setMMTitle(2131297939);
      break;
      label156:
      if (this.aoW == 1)
      {
        this.kyp = View.inflate(this, 2130968965, null);
        if (this.kkI != null) {
          this.kkI.addView(this.kyp);
        }
        i = 2131298058;
      }
      else
      {
        i = 2131297854;
      }
    }
  }
  
  public final n.a bay()
  {
    return n.a.koc;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(88672);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      ab.e("MicroMsg.CardViewUI", "onCreate intent is null");
      finish();
      AppMethodBeat.o(88672);
      return;
    }
    this.ejF = paramBundle.getIntExtra("key_previous_scene", 7);
    this.kua = paramBundle.getIntExtra("key_from_appbrand_type", 0);
    this.aoW = paramBundle.getIntExtra("view_type", 0);
    this.kyo = paramBundle.getStringExtra("user_name");
    this.mAppId = paramBundle.getStringExtra("key_app_id");
    paramBundle = paramBundle.getStringExtra("card_list");
    this.fhC = getIntent().getStringExtra("key_template_id");
    if (this.aoW == 0)
    {
      if (TextUtils.isEmpty(paramBundle))
      {
        ab.e("MicroMsg.CardViewUI", "oncreate card_list is empty");
        finish();
        AppMethodBeat.o(88672);
        return;
      }
      paramBundle = k.r(paramBundle, this.ejF, this.mAppId);
      if ((paramBundle != null) && (paramBundle.size() > 0))
      {
        this.ksE.clear();
        this.ksE.addAll(paramBundle);
      }
    }
    initView();
    AppMethodBeat.o(88672);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(88673);
    com.tencent.mm.kernel.g.RK().eHt.b(699, this);
    super.onDestroy();
    AppMethodBeat.o(88673);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 0;
    AppMethodBeat.i(88681);
    if ((paramm instanceof t))
    {
      fV(false);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((t)paramm).kop;
        if ((paramString != null) && (paramString.size() > 0))
        {
          if ((this.kkG instanceof g))
          {
            paramm = (g)this.kkG;
            if (paramString != null)
            {
              paramm.krw.clear();
              paramm.krw.addAll(paramString);
              paramm.kwt.clear();
              paramInt1 = i;
              while (paramInt1 < paramString.size())
              {
                paramm.kwt.add(Boolean.TRUE);
                paramInt1 += 1;
              }
            }
          }
          this.kkG.notifyDataSetChanged();
        }
        AppMethodBeat.o(88681);
        return;
      }
      d.b(this, paramString, paramInt2);
      AppMethodBeat.o(88681);
      return;
    }
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    AppMethodBeat.o(88681);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(88674);
    super.onSwipeBack();
    if (this.ejF == 26) {
      overridePendingTransition(0, 0);
    }
    AppMethodBeat.o(88674);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardViewUI
 * JD-Core Version:    0.7.0.1
 */