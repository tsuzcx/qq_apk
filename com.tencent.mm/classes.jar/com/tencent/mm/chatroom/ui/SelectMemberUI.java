package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.HashSet;
import java.util.List;

public class SelectMemberUI
  extends MMActivity
{
  protected u efi;
  protected String egF;
  private MMEditText eiX;
  private View ejB;
  private View ejC;
  private SelectMemberScrollBar ejD;
  protected SelectMemberUI.b ejE;
  protected int ejF;
  protected HashSet<String> ejG;
  private boolean ejH;
  private boolean ejI;
  private ListView mListView;
  protected String mTitle;
  
  protected static String a(u paramu, String paramString)
  {
    AppMethodBeat.i(104435);
    if (paramu == null)
    {
      AppMethodBeat.o(104435);
      return null;
    }
    paramu = paramu.nE(paramString);
    AppMethodBeat.o(104435);
    return paramu;
  }
  
  public boolean Kf()
  {
    return false;
  }
  
  protected void Kj()
  {
    AppMethodBeat.i(104430);
    this.egF = getIntent().getStringExtra("RoomInfo_Id");
    ab.i("MicroMsg.SelectMemberUI", "[getIntentParams] roomId:%s", new Object[] { this.egF });
    this.efi = ((c)g.E(c.class)).YJ().oV(this.egF);
    this.ejF = getIntent().getIntExtra("from_scene", 0);
    this.mTitle = getIntent().getStringExtra("title");
    this.ejH = getIntent().getBooleanExtra("is_show_owner", true);
    this.ejI = getIntent().getBooleanExtra("is_mulit_select_mode", false);
    this.ejG = new HashSet();
    AppMethodBeat.o(104430);
  }
  
  public boolean Kk()
  {
    return this.ejI;
  }
  
  protected HashSet<String> Kl()
  {
    AppMethodBeat.i(104433);
    HashSet localHashSet = new HashSet();
    AppMethodBeat.o(104433);
    return localHashSet;
  }
  
  protected HashSet<String> Kn()
  {
    AppMethodBeat.i(104432);
    HashSet localHashSet = new HashSet();
    AppMethodBeat.o(104432);
    return localHashSet;
  }
  
  protected boolean Ko()
  {
    return true;
  }
  
  protected BaseAdapter Kp()
  {
    return this.ejE;
  }
  
  protected List<String> Kq()
  {
    AppMethodBeat.i(104434);
    List localList = this.efi.afx();
    AppMethodBeat.o(104434);
    return localList;
  }
  
  public final u Ks()
  {
    return this.efi;
  }
  
  protected void a(View paramView, int paramInt, long paramLong) {}
  
  public int getLayoutId()
  {
    return 2130970657;
  }
  
  public void initView()
  {
    AppMethodBeat.i(104431);
    setMMTitle(bo.nullAsNil(this.mTitle));
    this.mListView = ((ListView)findViewById(2131827538));
    this.ejB = findViewById(2131827539);
    this.ejC = findViewById(2131827549);
    this.ejE = new SelectMemberUI.b(this, this, this.efi, this.egF, this.efi.field_roomowner);
    this.mListView.setAdapter(Kp());
    this.ejD = ((SelectMemberScrollBar)findViewById(2131827548));
    this.ejD.setOnScrollBarTouchListener(new SelectMemberUI.1(this));
    if (Ko()) {
      this.ejD.setVisibility(0);
    }
    for (;;)
    {
      this.eiX = ((MMEditText)findViewById(2131827547));
      this.eiX.addTextChangedListener(new SelectMemberUI.2(this));
      SelectMemberUI.b localb = this.ejE;
      localb.ejJ.ejC.setVisibility(0);
      g.RO().ac(new SelectMemberUI.b.1(localb));
      setBackBtn(new SelectMemberUI.3(this));
      AppMethodBeat.o(104431);
      return;
      this.ejD.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104429);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.SelectMemberUI", "[onCreate]");
    Kj();
    initView();
    AppMethodBeat.o(104429);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected void v(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI
 * JD-Core Version:    0.7.0.1
 */