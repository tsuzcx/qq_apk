package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.a.f;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.model.m;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.bi.b;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import java.util.Map;

public class SelectedMemberChattingRecordUI
  extends MMActivity
{
  private static final f<Integer, c> dss = new f(32);
  private String dpj;
  private View drT;
  private MMLoadMoreListView dso;
  private SelectedMemberChattingRecordUI.a dsp;
  private String dsq;
  private int dsr = 0;
  private String mTitle;
  
  public static String a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    String str = "";
    g.a locala = g.a.gp(paramString1);
    Object localObject;
    switch (paramInt1)
    {
    default: 
      localObject = str;
    case 1: 
    case 34: 
    case 3: 
    case 23: 
    case 33: 
    case 43: 
    case 62: 
    case 48: 
    case 42: 
    case 66: 
      do
      {
        return localObject;
        return paramString1.substring(paramString1.indexOf(":\n") + 1);
        paramString1 = new n(paramString1);
        return paramContext.getString(a.i.record_voice_with_time, new Object[] { Integer.valueOf((int)com.tencent.mm.modelvoice.q.ck(paramString1.time)) });
        return paramContext.getString(a.i.app_pic);
        if (62 == paramInt1) {}
        for (paramInt1 = a.i.app_shortvideo;; paramInt1 = a.i.app_video) {
          return paramContext.getString(paramInt1);
        }
        paramString1 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HO(paramString1);
        return paramContext.getString(a.i.record_location_with_title, new Object[] { paramString1.label });
        localObject = str;
      } while (bk.pm(paramString1).length() <= 0);
      localObject = com.tencent.mm.model.bd.iI(paramString1);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
    }
    for (;;)
    {
      localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HN(paramString1);
      paramString2 = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl(paramString2).Bq();
      paramString1 = paramString2;
      if (s.fn(paramString2)) {
        paramString1 = m.J(m.gN(paramString2));
      }
      if (paramInt2 == 1) {
        return paramContext.getString(a.i.fmt_card_from, new Object[] { paramString1, ((bi.a)localObject).getDisplayName() });
      }
      return paramContext.getString(a.i.fmt_card_to, new Object[] { paramString1, ((bi.a)localObject).getDisplayName() });
      if (locala == null)
      {
        y.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
        return "";
      }
      localObject = str;
      switch (locala.type)
      {
      case 7: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 16: 
      case 18: 
      case 20: 
      case 21: 
      case 22: 
      case 23: 
      default: 
        return "";
      case 6: 
        return paramContext.getString(a.i.record_file_with_title, new Object[] { locala.title });
      case 5: 
        return paramContext.getString(a.i.record_url_with_title, new Object[] { locala.getTitle() });
      case 8: 
        return paramContext.getString(a.i.app_emoji2);
      case 15: 
      case 26: 
      case 27: 
        return paramContext.getString(a.i.app_emoji);
      case 25: 
        return paramContext.getString(a.i.app_designer_share);
      case 17: 
        return paramContext.getString(a.i.record_location_with_title, new Object[] { locala.title });
      case 19: 
        return paramContext.getString(a.i.record_record_with_title, new Object[] { locala.title });
      case 24: 
        paramString2 = locala.dRd;
        if (bk.bl(paramString2))
        {
          y.e("MicroMsg.SelectedMemberChattingRecordUI", "xml is null");
          paramString1 = null;
          if (paramString1 != null) {
            break label967;
          }
        }
        for (paramString1 = "";; paramString1 = paramString1.desc)
        {
          return paramContext.getString(a.i.record_note_with_title, new Object[] { bk.aM(paramString1, "") });
          paramInt1 = paramString2.hashCode();
          paramString1 = (c)dss.get(Integer.valueOf(paramInt1));
          if (paramString1 != null)
          {
            y.d("MicroMsg.SelectedMemberChattingRecordUI", "get record msg data from cache");
            break;
          }
          if (paramString2.trim().startsWith("<recordinfo>")) {}
          for (paramString1 = bn.s(paramString2, "recordinfo");; paramString1 = bn.s("<recordinfo>" + paramString2 + "</recordinfo>", "recordinfo"))
          {
            if (paramString1 != null) {
              break label894;
            }
            y.e("MicroMsg.SelectedMemberChattingRecordUI", "values is null: %s", new Object[] { paramString2 });
            paramString1 = null;
            break;
          }
          paramString2 = new c();
          paramString2.title = ((String)paramString1.get(".recordinfo.title"));
          paramString2.desc = ((String)paramString1.get(".recordinfo.desc"));
          paramString2.srn = ((String)paramString1.get(".recordinfo.favusername"));
          dss.put(Integer.valueOf(paramInt1), paramString2);
          paramString1 = paramString2;
          break;
        }
      case 3: 
        label967:
        return paramContext.getString(a.i.record_music_with_title, new Object[] { locala.title });
      case 4: 
        label894:
        return paramContext.getString(a.i.record_video_with_title, new Object[] { locala.title });
      }
      return paramContext.getString(a.i.app_pic);
      return paramContext.getString(a.i.app_emoji);
      localObject = paramContext.getString(a.i.record_remittance_with_title);
      if (locala == null) {
        break;
      }
      if (paramInt2 == 1) {}
      for (paramInt1 = 1;; paramInt1 = 0) {
        switch (locala.dRE)
        {
        case 2: 
        default: 
          return bk.pm(locala.title);
        }
      }
      if (paramInt1 != 0) {
        return paramContext.getString(a.i.appmsg_remittance_digest_payer_wait);
      }
      return paramContext.getString(a.i.appmsg_remittance_digest_receiver_wait);
      if (paramInt1 != 0) {
        return paramContext.getString(a.i.appmsg_remittance_digest_receiver_collected);
      }
      return paramContext.getString(a.i.appmsg_remittance_digest_payer_collected);
      if (paramInt1 != 0) {
        return paramContext.getString(a.i.appmsg_remittance_digest_receiver_refused);
      }
      return paramContext.getString(a.i.appmsg_remittance_digest_payer_refused);
      if (locala == null)
      {
        y.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
        return "";
      }
      if (paramInt2 == 1) {
        return paramContext.getString(a.i.record_c2c_with_title, new Object[] { locala.dSf, locala.dSc });
      }
      return paramContext.getString(a.i.record_c2c_with_title, new Object[] { locala.dSf, locala.dSb });
      if (locala == null)
      {
        y.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
        return "";
      }
      if (paramInt2 == 1) {
        return paramContext.getString(a.i.record_c2c_with_title, new Object[] { locala.dSf, locala.dSt });
      }
      return paramContext.getString(a.i.record_c2c_with_title, new Object[] { locala.dSf, locala.dSs });
      return paramContext.getString(a.i.record_card_with_title, new Object[] { locala.title });
      return paramContext.getString(a.i.record_card_with_title, new Object[] { "" });
      return paramContext.getString(a.i.record_app_with_title, new Object[] { locala.title });
      return paramContext.getString(a.i.record_share_location_with_title, new Object[] { locala.title });
      localObject = str;
      if (paramString1 == null) {
        break;
      }
      localObject = str;
      if (paramString1.length() <= 0) {
        break;
      }
      paramString1 = bi.d.acc(paramString1);
      localObject = str;
      if (paramString1.pyp == null) {
        break;
      }
      localObject = str;
      if (paramString1.pyp.length() <= 0) {
        break;
      }
      switch (paramString1.scene)
      {
      case 19: 
      case 20: 
      case 21: 
      default: 
        return paramContext.getString(a.i.fmt_want_to_be_your_friend, new Object[] { paramString1.getDisplayName() });
      case 18: 
        return paramContext.getString(a.i.fmt_say_hello_to_you, new Object[] { paramString1.getDisplayName() });
      case 22: 
      case 23: 
      case 24: 
      case 26: 
      case 27: 
      case 28: 
      case 29: 
        return paramContext.getString(a.i.fmt_shake_say_hello_to_you, new Object[] { paramString1.getDisplayName() });
      }
      return paramContext.getString(a.i.fmt_bottle_say_hello_to_you, new Object[] { paramString1.getDisplayName() });
      paramString2 = (String)localObject;
    }
  }
  
  protected static String a(u paramu, String paramString)
  {
    if (paramu == null) {
      return null;
    }
    return paramu.gV(paramString);
  }
  
  protected final int getLayoutId()
  {
    return a.f.select_member_chatting_record_ui;
  }
  
  protected final void initView()
  {
    super.initView();
    setMMTitle(bk.pm(this.mTitle));
    this.dso = ((MMLoadMoreListView)findViewById(a.e.member_list));
    this.dso.cAO();
    this.dsp = new SelectedMemberChattingRecordUI.a(this, this, this.dpj, this.dsq, this.dsr);
    this.dso.setAdapter(this.dsp);
    this.drT = findViewById(a.e.select_member_ui_hint_ll);
    if (this.dsr == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.drT.setVisibility(0);
        this.dso.setVisibility(8);
      }
      this.dso.setOnItemClickListener(new SelectedMemberChattingRecordUI.1(this));
      this.dso.setOnLoadMoreListener(new SelectedMemberChattingRecordUI.2(this));
      setBackBtn(new SelectedMemberChattingRecordUI.3(this));
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.SelectedMemberChattingRecordUI", "[onCreate]");
    this.dpj = getIntent().getStringExtra("RoomInfo_Id");
    this.dsq = getIntent().getStringExtra("room_member");
    y.i("MicroMsg.SelectedMemberChattingRecordUI", "roomId:%s", new Object[] { this.dpj });
    this.mTitle = getIntent().getStringExtra("title");
    if ((!bk.bl(this.dsq)) && (com.tencent.mm.model.q.gS(this.dsq))) {
      this.dsr = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HY(this.dpj);
    }
    for (;;)
    {
      initView();
      return;
      if (!com.tencent.mm.model.q.gS(this.dsq)) {
        this.dsr = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().dR(this.dpj, this.dsq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI
 * JD-Core Version:    0.7.0.1
 */