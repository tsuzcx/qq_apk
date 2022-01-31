package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.af;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.List;

public class SeeAccessVerifyInfoUI
  extends MMActivity
{
  private u dnL;
  private SeeAccessVerifyInfoUI.b dqI;
  private String dqJ;
  private String dqK;
  private String dqL;
  private String dqM;
  private String dqN;
  private long dqO;
  private long dqP;
  private String dqQ;
  private String dqR;
  private String dqS;
  private TextView dqT;
  private TextView dqU;
  private ImageView dqV;
  private TextView dqW;
  private TextView dqX;
  private GridView dqY;
  private p tipDialog;
  
  protected final SeeAccessVerifyInfoUI.c bK(View paramView)
  {
    SeeAccessVerifyInfoUI.c localc = new SeeAccessVerifyInfoUI.c(this);
    localc.doU = ((ImageView)paramView.findViewById(a.e.roominfo_img));
    localc.drf = ((TextView)paramView.findViewById(a.e.roominfo_contact_name_for_span));
    return localc;
  }
  
  protected final int getLayoutId()
  {
    return a.f.see_accessverify_info_ui;
  }
  
  protected final void initView()
  {
    Object localObject1 = null;
    this.dqT = ((TextView)findViewById(a.e.invite_title));
    this.dqU = ((TextView)findViewById(a.e.invite_reason));
    this.dqW = ((TextView)findViewById(a.e.roominfo_contact_name_for_span));
    this.dqV = ((ImageView)findViewById(a.e.roominfo_img));
    this.dqX = ((TextView)findViewById(a.e.access_btn));
    this.dqY = ((GridView)findViewById(a.e.be_invitor_gridview));
    this.dqY.setAdapter(this.dqI);
    if (this.dqV != null) {
      this.dqV.setOnClickListener(new SeeAccessVerifyInfoUI.2(this));
    }
    this.dqY.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    this.dqY.postDelayed(new SeeAccessVerifyInfoUI.4(this), 100L);
    if (this.dqV != null) {
      com.tencent.mm.pluginsdk.ui.a.b.a(this.dqV, bk.pm(this.dqN));
    }
    TextView localTextView1;
    Object localObject2;
    TextView localTextView2;
    if (this.dqW != null)
    {
      localTextView1 = this.dqW;
      localObject2 = bk.pm(this.dqN);
      localTextView2 = this.dqW;
      if (localTextView2 != null) {
        break label399;
      }
    }
    label399:
    ad localad;
    for (;;)
    {
      localTextView1.setText((CharSequence)localObject1);
      if (this.dqT != null) {
        this.dqT.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this, bk.pm(this.dqM)));
      }
      if ((this.dqU != null) && (!bk.bl(this.dqR))) {
        this.dqU.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this, "\"" + bk.pm(this.dqR) + "\""));
      }
      if (this.dqX != null) {
        this.dqX.setOnClickListener(new SeeAccessVerifyInfoUI.5(this));
      }
      if ((this.dqX != null) && (((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().fd(this.dqO).cvF()))
      {
        this.dqX.setBackgroundResource(a.d.btn_solid_grey);
        this.dqX.setTextColor(getResources().getColor(a.b.grey_btn_stroke_color_normal));
        this.dqX.setText(getString(a.i.has_approve_info));
        this.dqX.setEnabled(false);
      }
      return;
      localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(bk.pm((String)localObject2));
      if (localad != null) {
        break;
      }
      y.w("MicroMsg.SeeAccessVerifyInfoUI", "ct == null");
    }
    if (!bk.bl(localad.field_conRemark)) {
      localObject1 = localad.field_conRemark;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (bk.bl((String)localObject1)) {
        localObject2 = localad.field_conRemark;
      }
      localObject1 = localObject2;
      if (bk.bl((String)localObject2)) {
        localObject1 = localad.Bp();
      }
      localObject1 = com.tencent.mm.pluginsdk.ui.d.j.a(this, bk.pm((String)localObject1), localTextView2.getTextSize());
      break;
      if (this.dnL != null) {
        localObject1 = this.dnL.gV((String)localObject2);
      } else {
        localObject1 = null;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.SeeAccessVerifyInfoUI", "[onCreate]");
    setMMTitle(getString(a.i.access_invite_ui_title));
    this.dqO = getIntent().getLongExtra("msgLocalId", 0L);
    this.dqP = getIntent().getLongExtra("msgSvrId", 0L);
    this.dqM = getIntent().getStringExtra("invitertitle");
    this.dqN = getIntent().getStringExtra("inviterusername");
    this.dqQ = getIntent().getStringExtra("chatroom");
    this.dqR = getIntent().getStringExtra("invitationreason");
    this.dqS = getIntent().getStringExtra("ticket");
    this.dqK = getIntent().getStringExtra("username");
    this.dqJ = getIntent().getStringExtra("nickname");
    this.dqL = getIntent().getStringExtra("headimgurl");
    this.dnL = ((c)com.tencent.mm.kernel.g.r(c.class)).FF().in(bk.pm(this.dqQ));
    this.dqI = new SeeAccessVerifyInfoUI.b(this, this);
    paramBundle = this.dqK.split(",");
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      paramBundle = paramBundle[0];
      y.i("MicroMsg.SeeAccessVerifyInfoUI", "[%s] has been in chatroom![%s]", new Object[] { paramBundle, this.dqQ });
      if ((this.dnL.MN() != null) && (this.dnL.MN().contains(paramBundle)))
      {
        paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().fd(this.dqO);
        if (!paramBundle.cvF())
        {
          paramBundle.cvE();
          ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().a(this.dqO, paramBundle);
        }
      }
    }
    initView();
    setBackBtn(new SeeAccessVerifyInfoUI.1(this));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onResume()
  {
    y.i("MicroMsg.SeeAccessVerifyInfoUI", "[onResume]");
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI
 * JD-Core Version:    0.7.0.1
 */