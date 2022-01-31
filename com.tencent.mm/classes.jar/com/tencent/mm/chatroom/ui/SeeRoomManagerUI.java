package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.c.b;
import com.tencent.mm.chatroom.c.d;
import com.tencent.mm.cm.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;

public class SeeRoomManagerUI
  extends MMActivity
  implements k.a
{
  private u efi;
  private String egT;
  private GridView eiB;
  private SeeRoomManagerUI.b eiO;
  private p tipDialog;
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(104300);
    if (paramm != null) {
      ab.i("MicroMsg.SeeRoomManagerUI", "[onNotifyChange] event:%s [%s:%s]", new Object[] { paramString, paramm.cnC, Integer.valueOf(paramm.htj) });
    }
    AppMethodBeat.o(104300);
  }
  
  protected final c cj(View paramView)
  {
    AppMethodBeat.i(104301);
    c localc = new c();
    localc.egq = ((ImageView)paramView.findViewById(2131827385));
    localc.eiM = ((TextView)paramView.findViewById(2131827390));
    AppMethodBeat.o(104301);
    return localc;
  }
  
  public int getLayoutId()
  {
    return 2130970640;
  }
  
  public void initView()
  {
    AppMethodBeat.i(104299);
    super.initView();
    setMMTitle(2131302726);
    this.eiB = ((GridView)findViewById(2131827526));
    this.eiO = new SeeRoomManagerUI.b(this, this);
    this.eiB.setAdapter(this.eiO);
    this.eiB.setOnTouchListener(new SeeRoomManagerUI.1(this));
    this.eiB.post(new SeeRoomManagerUI.2(this));
    setBackBtn(new SeeRoomManagerUI.3(this));
    AppMethodBeat.o(104299);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(104302);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramIntent == null) || (paramInt2 != -1))
    {
      if (paramIntent == null) {}
      for (boolean bool = true;; bool = false)
      {
        ab.w("MicroMsg.SeeRoomManagerUI", "[onActivityResult] data is null? %s resultCode:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(104302);
        return;
      }
    }
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    ab.i("MicroMsg.SeeRoomManagerUI", "[onActivityResult] roomName:%s requestCode:%s userListString:%s", new Object[] { this.egT, Integer.valueOf(paramInt1), paramIntent });
    if (bo.isNullOrNil(paramIntent))
    {
      ab.e("MicroMsg.SeeRoomManagerUI", "[onActivityResult] userListString is null!");
      AppMethodBeat.o(104302);
      return;
    }
    Object localObject = paramIntent.split(",");
    paramIntent = new LinkedList();
    int i = localObject.length;
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      paramIntent.add(localObject[paramInt2]);
      paramInt2 += 1;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(104302);
      return;
      localObject = getContext();
      getString(2131297087);
      this.tipDialog = h.b((Context)localObject, getString(2131302662), false, null);
      new b(this.egT, paramIntent).adl().b(this).b(new SeeRoomManagerUI.4(this, paramIntent));
      AppMethodBeat.o(104302);
      return;
      localObject = getContext();
      getString(2131297087);
      this.tipDialog = h.b((Context)localObject, getString(2131302683), false, null);
      new d(this.egT, paramIntent).adl().b(this).b(new SeeRoomManagerUI.5(this, paramIntent));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104297);
    super.onCreate(paramBundle);
    ((c)g.E(c.class)).YJ().add(this);
    this.egT = getIntent().getStringExtra("RoomInfo_Id");
    initView();
    AppMethodBeat.o(104297);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104298);
    super.onDestroy();
    ((c)g.E(c.class)).YJ().remove(this);
    AppMethodBeat.o(104298);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
  {
    public ad contact;
    public int type;
    
    public a(int paramInt, ad paramad)
    {
      this.type = paramInt;
      this.contact = paramad;
    }
  }
  
  final class c
  {
    public ImageView egq;
    public TextView eiM;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomManagerUI
 * JD-Core Version:    0.7.0.1
 */