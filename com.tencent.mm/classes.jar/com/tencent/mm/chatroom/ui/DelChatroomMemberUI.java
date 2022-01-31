package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  private String chatroomName;
  private u efi;
  private DelChatroomMemberUI.a egg;
  private LinkedList<String> egh;
  private ListView mListView;
  private int scene;
  private p tipDialog;
  
  public DelChatroomMemberUI()
  {
    AppMethodBeat.i(104096);
    this.egh = new LinkedList();
    AppMethodBeat.o(104096);
  }
  
  public int getLayoutId()
  {
    return 2130969025;
  }
  
  public void initView()
  {
    AppMethodBeat.i(104100);
    setMMTitle(2131302699);
    this.mListView = ((ListView)findViewById(2131822428));
    this.egg = new DelChatroomMemberUI.a(this);
    DelChatroomMemberUI.a locala = this.egg;
    Object localObject = this.egh;
    if (localObject != null)
    {
      ab.i("MicroMsg.DelChatroomMemberAdapter", "initData members.size %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
      locala.egm.clear();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        ad localad = ((j)g.E(j.class)).YA().arw(str);
        if ((localad != null) && (!bo.isNullOrNil(localad.field_username)) && (localad.field_username.equals(str))) {
          locala.egm.add(localad);
        }
      }
    }
    this.mListView.setAdapter(this.egg);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(104083);
        DelChatroomMemberUI.this.finish();
        AppMethodBeat.o(104083);
        return true;
      }
    });
    AppMethodBeat.o(104100);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(104097);
    super.onCreate(paramBundle);
    this.chatroomName = getIntent().getStringExtra("RoomInfo_Id");
    this.scene = getIntent().getIntExtra("scene", 0);
    paramBundle = getIntent().getStringExtra("members").split(",");
    int j = paramBundle.length;
    while (i < j)
    {
      Object localObject = paramBundle[i];
      this.egh.add(localObject);
      i += 1;
    }
    this.efi = ((c)g.E(c.class)).YJ().oU(this.chatroomName);
    initView();
    AppMethodBeat.o(104097);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104098);
    super.onDestroy();
    AppMethodBeat.o(104098);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(104099);
    super.onResume();
    AppMethodBeat.o(104099);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(104101);
    ab.i("MicroMsg.DelChatroomMemberUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(104101);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.DelChatroomMemberUI
 * JD-Core Version:    0.7.0.1
 */