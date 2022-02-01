package com.tencent.mm.plugin.game.chatroom.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.d;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.autogen.chatroom.BanAction;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomJumpDetail;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;
import com.tencent.mm.plugin.game.chatroom.e;
import com.tencent.mm.plugin.game.chatroom.h.d;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.ui.aw;
import java.util.LinkedList;
import java.util.List;

public class ChatRoomFooterView
  extends LinearLayout
{
  long Ijq;
  long Ijr;
  private Lbs ImF;
  List<BanAction> InN;
  View IoD;
  ImageView IoE;
  TextView IoF;
  View IoG;
  ImageView IoH;
  TextView IoI;
  View IoJ;
  private ImageView IoK;
  private Context mContext;
  
  public ChatRoomFooterView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(276380);
    this.InN = new LinkedList();
    initView();
    AppMethodBeat.o(276380);
  }
  
  public ChatRoomFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(276385);
    this.InN = new LinkedList();
    initView();
    AppMethodBeat.o(276385);
  }
  
  public ChatRoomFooterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(276392);
    this.InN = new LinkedList();
    initView();
    AppMethodBeat.o(276392);
  }
  
  private void initView()
  {
    AppMethodBeat.i(276401);
    this.mContext = getContext();
    this.Ijr = ((Activity)this.mContext).getIntent().getLongExtra("game_report_sourceid", 0L);
    this.Ijq = ((Activity)this.mContext).getIntent().getLongExtra("game_report_ssid", 0L);
    LayoutInflater.from(this.mContext).inflate(h.f.IhC, this, true);
    this.IoD = findViewById(h.e.IfH);
    this.IoE = ((ImageView)findViewById(h.e.IfG));
    this.IoF = ((TextView)findViewById(h.e.IfI));
    this.IoG = findViewById(h.e.Ifr);
    this.IoH = ((ImageView)findViewById(h.e.Ifq));
    this.IoI = ((TextView)findViewById(h.e.Ifs));
    this.IoJ = findViewById(h.e.IfK);
    this.IoK = ((ImageView)findViewById(h.e.IfA));
    if (aw.isDarkMode())
    {
      this.IoK.setImageResource(h.d.IeC);
      AppMethodBeat.o(276401);
      return;
    }
    this.IoK.setImageResource(h.d.IeD);
    AppMethodBeat.o(276401);
  }
  
  public void setLbsInfo(Lbs paramLbs)
  {
    this.ImF = paramLbs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.ChatRoomFooterView
 * JD-Core Version:    0.7.0.1
 */