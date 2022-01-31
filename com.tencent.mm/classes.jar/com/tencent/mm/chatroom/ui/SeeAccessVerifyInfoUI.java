package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.t;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.b.i;
import com.tencent.mm.openim.e.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import java.util.List;

public class SeeAccessVerifyInfoUI
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  private u efi;
  private TextView eiA;
  private GridView eiB;
  private boolean eiC = false;
  private boolean eiD = false;
  private boolean eiE = false;
  private SeeAccessVerifyInfoUI.b eig;
  private String eih;
  private String eii;
  private String eij;
  private String eik;
  private String eil;
  private String eim;
  private String ein;
  private String eio;
  private String eip;
  private long eiq;
  private long eir;
  private String eis;
  private String eit;
  private String eiu;
  private TextView eiv;
  private TextView eiw;
  private ImageView eix;
  private TextView eiy;
  private TextView eiz;
  private com.tencent.mm.ui.base.p tipDialog;
  
  protected final SeeAccessVerifyInfoUI.c ci(View paramView)
  {
    AppMethodBeat.i(104279);
    SeeAccessVerifyInfoUI.c localc = new SeeAccessVerifyInfoUI.c(this);
    localc.egq = ((ImageView)paramView.findViewById(2131827385));
    localc.eiM = ((TextView)paramView.findViewById(2131827390));
    localc.eiN = ((TextView)paramView.findViewById(2131827391));
    AppMethodBeat.o(104279);
    return localc;
  }
  
  public int getLayoutId()
  {
    return 2130970639;
  }
  
  public void initView()
  {
    Object localObject1 = null;
    AppMethodBeat.i(104276);
    this.eiv = ((TextView)findViewById(2131827521));
    this.eiw = ((TextView)findViewById(2131827522));
    this.eiy = ((TextView)findViewById(2131827390));
    this.eiz = ((TextView)findViewById(2131827391));
    this.eix = ((ImageView)findViewById(2131827385));
    this.eiA = ((TextView)findViewById(2131827524));
    this.eiB = ((GridView)findViewById(2131827523));
    this.eiB.setAdapter(this.eig);
    if (this.eix != null) {
      this.eix.setOnClickListener(new SeeAccessVerifyInfoUI.2(this));
    }
    this.eiB.setOnTouchListener(new SeeAccessVerifyInfoUI.3(this));
    this.eiB.postDelayed(new SeeAccessVerifyInfoUI.4(this), 100L);
    if (this.eix != null) {
      a.b.c(this.eix, bo.nullAsNil(this.ein));
    }
    TextView localTextView1;
    Object localObject2;
    TextView localTextView2;
    if (this.eiy != null)
    {
      localTextView1 = this.eiy;
      localObject2 = bo.nullAsNil(this.ein);
      localTextView2 = this.eiy;
      if (localTextView2 != null) {
        break label574;
      }
    }
    label379:
    ad localad;
    for (;;)
    {
      localTextView1.setText((CharSequence)localObject1);
      if (this.eiz != null)
      {
        if ((!t.nK(this.eis)) || (!ad.arf(this.ein))) {
          break label777;
        }
        localObject1 = new e();
        ((e)localObject1).field_appid = this.eio;
        ((e)localObject1).field_wordingId = this.eip;
        ((e)localObject1).field_language = aa.gP(ah.getContext());
        g.RM();
        ((PluginOpenIM)g.G(PluginOpenIM.class)).getWordingInfoStg().get((com.tencent.mm.sdk.e.c)localObject1, new String[] { "appid", "wordingId", "language" });
        if (TextUtils.isEmpty(((e)localObject1).field_wording)) {
          break label697;
        }
        this.eiz.setVisibility(0);
        this.eiz.setText("＠" + ((e)localObject1).field_wording);
      }
      if (this.eiv != null) {
        this.eiv.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this, bo.nullAsNil(this.eim)));
      }
      if ((this.eiw != null) && (!bo.isNullOrNil(this.eit))) {
        this.eiw.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this, "\"" + bo.nullAsNil(this.eit) + "\""));
      }
      if (this.eiA != null) {
        this.eiA.setOnClickListener(new SeeAccessVerifyInfoUI.5(this));
      }
      if ((this.eiA != null) && (((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().kB(this.eiq).dyn()))
      {
        this.eiA.setBackgroundResource(2130838047);
        this.eiA.setTextColor(getResources().getColor(2131690153));
        this.eiA.setText(getString(2131300634));
        this.eiA.setEnabled(false);
      }
      AppMethodBeat.o(104276);
      return;
      label574:
      localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(bo.nullAsNil((String)localObject2));
      if (localad != null) {
        break;
      }
      ab.w("MicroMsg.SeeAccessVerifyInfoUI", "ct == null");
    }
    if (!bo.isNullOrNil(localad.field_conRemark)) {
      localObject1 = localad.field_conRemark;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (bo.isNullOrNil((String)localObject1)) {
        localObject2 = localad.field_conRemark;
      }
      localObject1 = localObject2;
      if (bo.isNullOrNil((String)localObject2)) {
        localObject1 = localad.Oe();
      }
      localObject1 = com.tencent.mm.pluginsdk.ui.d.j.b(this, bo.nullAsNil((String)localObject1), localTextView2.getTextSize());
      break;
      if (this.efi != null)
      {
        localObject1 = this.efi.nE((String)localObject2);
        continue;
        label697:
        if ((!bo.isNullOrNil(this.eip)) && (!bo.isNullOrNil(this.eio)))
        {
          this.eiE = true;
          localObject2 = new LinkedList();
          ((LinkedList)localObject2).add(this.eip);
          g.RK().eHt.a(new i(this.eio, ((e)localObject1).field_language, (LinkedList)localObject2), 0);
        }
        this.eiz.setVisibility(4);
        break label379;
        label777:
        this.eiz.setVisibility(8);
        break label379;
      }
      localObject1 = null;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104273);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.SeeAccessVerifyInfoUI", "[onCreate]");
    setMMTitle(getString(2131296395));
    this.eiq = getIntent().getLongExtra("msgLocalId", 0L);
    this.eir = getIntent().getLongExtra("msgSvrId", 0L);
    this.eim = getIntent().getStringExtra("invitertitle");
    this.ein = getIntent().getStringExtra("inviterusername");
    this.eio = getIntent().getStringExtra("inviterappid");
    this.eip = getIntent().getStringExtra("inviterdescid");
    this.eis = getIntent().getStringExtra("chatroom");
    this.eit = getIntent().getStringExtra("invitationreason");
    this.eiu = getIntent().getStringExtra("ticket");
    this.eii = getIntent().getStringExtra("username");
    this.eih = getIntent().getStringExtra("nickname");
    this.eij = getIntent().getStringExtra("descid");
    this.eik = getIntent().getStringExtra("appid");
    this.eil = getIntent().getStringExtra("headimgurl");
    this.efi = ((com.tencent.mm.plugin.chatroom.a.c)g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().oV(bo.nullAsNil(this.eis));
    this.eig = new SeeAccessVerifyInfoUI.b(this, this);
    paramBundle = this.eii.split(",");
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      paramBundle = paramBundle[0];
      ab.i("MicroMsg.SeeAccessVerifyInfoUI", "[%s] has been in chatroom![%s]", new Object[] { paramBundle, this.eis });
      if ((this.efi.afx() != null) && (this.efi.afx().contains(paramBundle)))
      {
        paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().kB(this.eiq);
        if (!paramBundle.dyn())
        {
          paramBundle.dyl();
          ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().a(this.eiq, paramBundle);
        }
      }
    }
    initView();
    setBackBtn(new SeeAccessVerifyInfoUI.1(this));
    AppMethodBeat.o(104273);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104275);
    super.onDestroy();
    g.RK().eHt.b(453, this);
    AppMethodBeat.o(104275);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(104274);
    ab.i("MicroMsg.SeeAccessVerifyInfoUI", "[onResume]");
    g.RK().eHt.a(453, this);
    super.onResume();
    AppMethodBeat.o(104274);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(104277);
    if (((paramm instanceof i)) && (paramInt1 == 0) && (paramInt2 == 0)) {
      if ((this.eiE) && (bo.aa(this.eiz.getText())))
      {
        this.eiE = false;
        paramString = new e();
        paramString.field_appid = this.eio;
        paramString.field_wordingId = this.eip;
        paramString.field_language = aa.gP(ah.getContext());
        g.RM();
        ((PluginOpenIM)g.G(PluginOpenIM.class)).getWordingInfoStg().get(paramString, new String[] { "appid", "wordingId", "language" });
        if (TextUtils.isEmpty(paramString.field_wording)) {
          break label190;
        }
        this.eiz.setVisibility(0);
        this.eiz.setText("＠" + paramString.field_wording);
      }
    }
    for (;;)
    {
      if (this.eiD) {
        this.eig.notifyDataSetChanged();
      }
      AppMethodBeat.o(104277);
      return;
      label190:
      if ((!bo.isNullOrNil(this.eip)) && (!bo.isNullOrNil(this.eio)))
      {
        paramm = new LinkedList();
        paramm.add(this.eip);
        g.RK().eHt.a(new i(this.eio, paramString.field_language, paramm), 0);
      }
      this.eiz.setVisibility(4);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI
 * JD-Core Version:    0.7.0.1
 */