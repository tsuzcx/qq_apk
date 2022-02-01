package com.tencent.mm.plugin.game.chatroom.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.d;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomData;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomUserData;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;
import com.tencent.mm.plugin.game.autogen.chatroom.RestrictRule;
import com.tencent.mm.plugin.game.chatroom.f.b;
import com.tencent.mm.plugin.game.chatroom.f.e;
import com.tencent.mm.plugin.game.chatroom.f.f;
import com.tencent.mm.plugin.game.chatroom.f.g;
import com.tencent.mm.plugin.game.chatroom.f.h;
import com.tencent.mm.plugin.game.luggage.h;
import com.tencent.mm.plugin.game.luggage.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.h.a.a;
import java.util.LinkedList;
import java.util.List;

public class JoinChatRoomConfirmView
  extends LinearLayout
{
  private long CxV;
  private TextView CxY;
  private TextView CxZ;
  private ImageView Cya;
  private TextView Cyb;
  private ImageView Cyc;
  private Context context;
  private TextView kEs;
  private TextView kJW;
  private long ssid;
  private ImageView vpB;
  
  public JoinChatRoomConfirmView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(210884);
    initView();
    AppMethodBeat.o(210884);
  }
  
  public JoinChatRoomConfirmView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(210885);
    initView();
    AppMethodBeat.o(210885);
  }
  
  private void a(TextView paramTextView, ImageView paramImageView, RestrictRule paramRestrictRule)
  {
    AppMethodBeat.i(210888);
    paramTextView.setText(paramRestrictRule.rule_desc);
    paramTextView.setVisibility(0);
    paramImageView.setVisibility(0);
    if (paramRestrictRule.can_pass)
    {
      paramTextView.setTextColor(this.context.getResources().getColor(f.b.UN_Yellow_90));
      paramImageView.setImageResource(f.g.chat_room_rule_pass_dark);
      AppMethodBeat.o(210888);
      return;
    }
    paramTextView.setTextColor(this.context.getResources().getColor(f.b.BW_100_Alpha_0_5));
    paramImageView.setImageResource(f.g.chat_room_rule_reject_dark);
    AppMethodBeat.o(210888);
  }
  
  private void initView()
  {
    AppMethodBeat.i(210886);
    this.context = getContext();
    this.CxV = ((Activity)this.context).getIntent().getLongExtra("game_report_sourceid", 0L);
    this.ssid = ((Activity)this.context).getIntent().getLongExtra("game_report_ssid", 0L);
    LayoutInflater.from(this.context).inflate(f.f.CtT, this, true);
    this.CxY = ((TextView)findViewById(f.e.Cta));
    this.CxZ = ((TextView)findViewById(f.e.CsZ));
    this.Cya = ((ImageView)findViewById(f.e.CsY));
    this.Cyb = ((TextView)findViewById(f.e.Ctc));
    this.Cyc = ((ImageView)findViewById(f.e.Ctb));
    this.kJW = ((TextView)findViewById(f.e.CsV));
    this.vpB = ((ImageView)findViewById(f.e.Ctd));
    this.kEs = ((TextView)findViewById(f.e.CsX));
    AppMethodBeat.o(210886);
  }
  
  public final void a(String paramString, ChatroomData paramChatroomData, ChatroomUserData paramChatroomUserData, Lbs paramLbs, JumpInfo paramJumpInfo)
  {
    AppMethodBeat.i(210887);
    if ((paramChatroomData == null) || (Util.isNullOrNil(paramString)) || (paramChatroomUserData == null))
    {
      AppMethodBeat.o(210887);
      return;
    }
    setVisibility(0);
    LinkedList localLinkedList = paramChatroomData.rule_list;
    if (!Util.isNullOrNil(localLinkedList))
    {
      this.CxY.setVisibility(0);
      if (localLinkedList.size() > 0) {
        a(this.CxZ, this.Cya, (RestrictRule)localLinkedList.get(0));
      }
      if (localLinkedList.size() > 1) {
        a(this.Cyb, this.Cyc, (RestrictRule)localLinkedList.get(1));
      }
    }
    a.c(this.vpB, paramString);
    paramString = (GradientDrawable)this.kJW.getBackground();
    if (paramChatroomData.can_join)
    {
      if ((!paramChatroomUserData.is_authorized) && (paramJumpInfo != null) && (!Util.isNullOrNil(paramJumpInfo.jump_url))) {
        h.a(i.class, paramJumpInfo.jump_url, null);
      }
      paramJumpInfo = d.jTj;
      d.a.b(0L, 1L, 1L, this.ssid, this.CxV);
      this.kEs.setText(f.h.Cuu);
      paramString.setColor(this.context.getResources().getColor(f.b.UN_Brand));
      this.kJW.setTextColor(this.context.getResources().getColor(f.b.BW_BG_100));
      this.kJW.setClickable(true);
      this.kJW.setOnClickListener(new JoinChatRoomConfirmView.1(this, paramChatroomUserData, paramChatroomData, paramLbs));
      AppMethodBeat.o(210887);
      return;
    }
    paramChatroomData = d.jTj;
    d.a.b(0L, 1L, 2L, this.ssid, this.CxV);
    this.kEs.setText(f.h.Cuv);
    paramString.setColor(this.context.getResources().getColor(f.b.gallery_btn_disable_color));
    this.kJW.setTextColor(this.context.getResources().getColor(f.b.BW_100_Alpha_0_2));
    this.kJW.setClickable(false);
    AppMethodBeat.o(210887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.JoinChatRoomConfirmView
 * JD-Core Version:    0.7.0.1
 */