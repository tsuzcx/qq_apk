package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DelChatroomMemberUI
  extends MMActivity
  implements f
{
  private ListView Nn;
  private String chatroomName;
  private u dnL;
  private DelChatroomMemberUI.a doK;
  private LinkedList<String> doL = new LinkedList();
  private int scene;
  private p tipDialog;
  
  protected final int getLayoutId()
  {
    return a.f.chatroom_delete_member;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.room_delete_member_title);
    this.Nn = ((ListView)findViewById(a.e.memberlist));
    this.doK = new DelChatroomMemberUI.a(this);
    DelChatroomMemberUI.a locala = this.doK;
    Object localObject = this.doL;
    if (localObject != null)
    {
      y.i("MicroMsg.DelChatroomMemberAdapter", "initData members.size %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
      locala.doQ.clear();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        ad localad = ((j)g.r(j.class)).Fw().abl(str);
        if ((localad != null) && (!bk.bl(localad.field_username)) && (localad.field_username.equals(str))) {
          locala.doQ.add(localad);
        }
      }
    }
    this.Nn.setAdapter(this.doK);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        DelChatroomMemberUI.this.finish();
        return true;
      }
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 0;
    super.onCreate(paramBundle);
    this.chatroomName = getIntent().getStringExtra("RoomInfo_Id");
    this.scene = getIntent().getIntExtra("scene", 0);
    paramBundle = getIntent().getStringExtra("members").split(",");
    int j = paramBundle.length;
    while (i < j)
    {
      Object localObject = paramBundle[i];
      this.doL.add(localObject);
      i += 1;
    }
    this.dnL = ((c)g.r(c.class)).FF().in(this.chatroomName);
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.DelChatroomMemberUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.DelChatroomMemberUI
 * JD-Core Version:    0.7.0.1
 */