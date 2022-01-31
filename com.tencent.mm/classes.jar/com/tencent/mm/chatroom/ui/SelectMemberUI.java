package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.HashSet;
import java.util.List;

public class SelectMemberUI
  extends MMActivity
{
  private ListView Nn;
  protected u dnL;
  protected String dpj;
  private View drT;
  private View drU;
  private SelectMemberScrollBar drV;
  protected SelectMemberUI.b drW;
  protected int drX;
  protected HashSet<String> drY;
  private boolean drZ;
  private MMEditText drp;
  private boolean dsa;
  protected String mTitle;
  
  protected static String a(u paramu, String paramString)
  {
    if (paramu == null) {
      return null;
    }
    return paramu.gV(paramString);
  }
  
  protected void a(View paramView, int paramInt, long paramLong) {}
  
  protected final int getLayoutId()
  {
    return a.f.select_member_ui;
  }
  
  protected void initView()
  {
    setMMTitle(bk.pm(this.mTitle));
    this.Nn = ((ListView)findViewById(a.e.member_list));
    this.drT = findViewById(a.e.select_member_ui_hint_ll);
    this.drU = findViewById(a.e.select_member_ui_loading);
    this.drW = new SelectMemberUI.b(this, this, this.dnL, this.dpj, this.dnL.field_roomowner);
    this.Nn.setAdapter(xX());
    this.drV = ((SelectMemberScrollBar)findViewById(a.e.member_scrollbar));
    this.drV.setOnScrollBarTouchListener(new SelectMemberUI.1(this));
    if (xW()) {
      this.drV.setVisibility(0);
    }
    for (;;)
    {
      this.drp = ((MMEditText)findViewById(a.e.select_member_et));
      this.drp.addTextChangedListener(new SelectMemberUI.2(this));
      SelectMemberUI.b localb = this.drW;
      localb.dsb.drU.setVisibility(0);
      g.DS().O(new SelectMemberUI.b.1(localb));
      setBackBtn(new SelectMemberUI.3(this));
      return;
      this.drV.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.SelectMemberUI", "[onCreate]");
    xR();
    initView();
  }
  
  protected void u(int paramInt, boolean paramBoolean) {}
  
  public boolean xN()
  {
    return false;
  }
  
  protected void xR()
  {
    this.dpj = getIntent().getStringExtra("RoomInfo_Id");
    y.i("MicroMsg.SelectMemberUI", "[getIntentParams] roomId:%s", new Object[] { this.dpj });
    this.dnL = ((c)g.r(c.class)).FF().io(this.dpj);
    this.drX = getIntent().getIntExtra("from_scene", 0);
    this.mTitle = getIntent().getStringExtra("title");
    this.drZ = getIntent().getBooleanExtra("is_show_owner", true);
    this.dsa = getIntent().getBooleanExtra("is_mulit_select_mode", false);
    this.drY = new HashSet();
  }
  
  public boolean xS()
  {
    return this.dsa;
  }
  
  protected HashSet<String> xT()
  {
    return new HashSet();
  }
  
  protected HashSet<String> xV()
  {
    return new HashSet();
  }
  
  protected boolean xW()
  {
    return true;
  }
  
  protected BaseAdapter xX()
  {
    return this.drW;
  }
  
  protected List<String> xY()
  {
    return this.dnL.MN();
  }
  
  public final u ya()
  {
    return this.dnL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI
 * JD-Core Version:    0.7.0.1
 */