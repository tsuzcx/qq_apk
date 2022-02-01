package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.chatroom.d.o;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.applet.aa.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class RoomRightUI
  extends MMPreference
  implements com.tencent.mm.ak.g
{
  private ProgressDialog fts = null;
  private String fya = "";
  private int fyb = 0;
  private f screen;
  
  private void WH()
  {
    AppMethodBeat.i(12756);
    int i = bs.a((Integer)com.tencent.mm.kernel.g.agR().agA().get(135175, null), 0);
    Object localObject1 = this.screen.aPN("settings_room_size");
    int j;
    if ((localObject1 != null) && (i > 0))
    {
      ((Preference)localObject1).setSummary(getResources().getQuantityString(2131623964, i, new Object[] { Integer.valueOf(i) }));
      ((Preference)localObject1).setEnabled(false);
      this.screen.aPN("room_right_max_tip").setTitle(getString(2131762684, new Object[] { Integer.valueOf(i) }));
      j = bs.a((Integer)com.tencent.mm.kernel.g.agR().agA().get(135176, null), 0);
      localObject1 = (RoomGrantPreference)this.screen.aPN("settings_room_grant");
      if ((localObject1 == null) || (j > 0)) {
        break label295;
      }
      this.screen.d((Preference)localObject1);
    }
    Preference localPreference;
    Object localObject2;
    for (;;)
    {
      localPreference = this.screen.aPN("room_right_tip");
      localObject2 = this.screen.aPN("room_right_grant_tip");
      if (j > 0) {
        break label361;
      }
      if (localPreference != null) {
        this.screen.d(localPreference);
      }
      if (localObject2 != null) {
        this.screen.d((Preference)localObject2);
      }
      localObject2 = this.screen.aPN("room_grant_to_friend");
      if (localObject2 != null) {
        this.screen.d((Preference)localObject2);
      }
      if (localObject1 != null) {
        this.screen.d((Preference)localObject1);
      }
      AppMethodBeat.o(12756);
      return;
      if (localObject1 == null) {
        break;
      }
      this.screen.d((Preference)localObject1);
      break;
      label295:
      if (localObject1 != null)
      {
        ((RoomGrantPreference)localObject1).setEnabled(false);
        localObject2 = getString(2131762687, new Object[] { Integer.valueOf(j) });
        ((RoomGrantPreference)localObject1).fxT = ((String)localObject2);
        if (((RoomGrantPreference)localObject1).fxS != null) {
          ((RoomGrantPreference)localObject1).fxS.setText((CharSequence)localObject2);
        }
      }
    }
    label361:
    localObject1 = getString(2131762688, new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    if (localPreference != null) {
      localPreference.setTitle((CharSequence)localObject1);
    }
    localObject1 = getString(2131762681, new Object[] { Integer.valueOf(this.fyb) });
    if (localObject2 != null) {
      ((Preference)localObject2).setTitle((CharSequence)localObject1);
    }
    AppMethodBeat.o(12756);
  }
  
  private void a(final LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(12763);
    if (paramLinkedList.size() > 0) {}
    String str;
    LinkedList localLinkedList;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      str = ai.getContext().getString(2131757106);
      paramLinkedList.size();
      localLinkedList = new LinkedList();
      if (!com.tencent.mm.kernel.g.agM()) {
        break;
      }
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext()) {
        localLinkedList.add(v.wk((String)localIterator.next()));
      }
    }
    h.d(this, getString(2131762685, new Object[] { bs.n(localLinkedList, str) }), getString(2131755906), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(12755);
        RoomRightUI.a(RoomRightUI.this, paramLinkedList);
        AppMethodBeat.o(12755);
      }
    });
    AppMethodBeat.o(12763);
  }
  
  public int getResourceId()
  {
    return 2131951705;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12761);
    this.screen = getPreferenceScreen();
    setMMTitle(2131763390);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(12752);
        RoomRightUI.this.hideVKB();
        RoomRightUI.this.finish();
        AppMethodBeat.o(12752);
        return true;
      }
    });
    AppMethodBeat.o(12761);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(12762);
    ac.i("MicroMsg.RoomRightUI", "onAcvityResult requestCode: %d", new Object[] { Integer.valueOf(paramInt1) });
    if ((paramInt2 != -1) || (paramIntent == null))
    {
      AppMethodBeat.o(12762);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(12762);
      return;
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      ac.d("MicroMsg.RoomRightUI", "pick user %s", new Object[] { paramIntent });
      if (bs.isNullOrNil(paramIntent))
      {
        AppMethodBeat.o(12762);
        return;
      }
      this.fya = paramIntent;
      paramIntent = this.fya;
      String str = getString(2131762617, new Object[] { ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(paramIntent).aaS(), Integer.valueOf(this.fyb) });
      h.a(getContext(), str, "", new DialogInterface.OnClickListener()
      {
        public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(12754);
          paramAnonymousDialogInterface = new o(paramIntent);
          RoomRightUI localRoomRightUI1 = RoomRightUI.this;
          RoomRightUI localRoomRightUI2 = RoomRightUI.this;
          RoomRightUI.this.getString(2131755906);
          RoomRightUI.a(localRoomRightUI1, h.b(localRoomRightUI2, "", true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(12753);
              com.tencent.mm.kernel.g.agQ().ghe.a(paramAnonymousDialogInterface);
              AppMethodBeat.o(12753);
            }
          }));
          com.tencent.mm.kernel.g.agQ().ghe.a(paramAnonymousDialogInterface, 0);
          AppMethodBeat.o(12754);
        }
      }, null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12757);
    super.onCreate(paramBundle);
    this.fyb = bs.a((Integer)com.tencent.mm.kernel.g.agR().agA().get(135177, null), 0);
    com.tencent.mm.kernel.g.agQ().ghe.a(339, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(30, this);
    com.tencent.mm.kernel.g.agR().agA().set(135184, Boolean.FALSE);
    initView();
    AppMethodBeat.o(12757);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12760);
    super.onDestroy();
    com.tencent.mm.kernel.g.agQ().ghe.b(339, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(30, this);
    AppMethodBeat.o(12760);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(12759);
    if (paramPreference.mKey.equals("room_grant_to_friend"))
    {
      paramf = new Intent();
      paramf.setClassName(ai.getPackageName(), ai.getPackageName() + ".ui.contact.SelectContactUI");
      paramf.putExtra("Contact_GroupFilter_Type", "@all.contact.without.chatroom");
      paramf.putExtra("List_Type", 4);
      paramf.putExtra("select_contact_pick_result", true);
      paramPreference = new LinkedList();
      paramPreference.add("officialaccounts");
      paramf.putExtra("Block_list", bs.n(paramPreference, ","));
      paramf.putExtra("Add_SendCard", true);
      paramf.putExtra("is_multi_select", false);
      startActivityForResult(paramf, 1);
    }
    AppMethodBeat.o(12759);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12758);
    super.onResume();
    WH();
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(12758);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(12764);
    ac.i("MicroMsg.RoomRightUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fts != null) {
      this.fts.dismiss();
    }
    if (paramn.getType() != 339)
    {
      AppMethodBeat.o(12764);
      return;
    }
    paramString = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(this.fya);
    if ((paramString == null) || ((int)paramString.fLJ == 0)) {}
    for (paramString = this.fya; (paramInt1 == 0) && (paramInt2 == 0); paramString = paramString.aaS())
    {
      h.c(this, getString(2131762620, new Object[] { paramString }), getString(2131755906), true);
      if (this.screen != null)
      {
        WH();
        this.screen.notifyDataSetChanged();
      }
      AppMethodBeat.o(12764);
      return;
    }
    if (paramInt2 == -251)
    {
      h.c(this, getString(2131762618, new Object[] { paramString, Integer.valueOf(this.fyb) }), getString(2131755906), true);
      AppMethodBeat.o(12764);
      return;
    }
    if (paramInt2 == -44)
    {
      paramString = new LinkedList();
      paramString.add(this.fya);
      a(paramString);
      AppMethodBeat.o(12764);
      return;
    }
    if (paramInt2 == -22)
    {
      h.c(this, getString(2131762619, new Object[] { paramString }), getString(2131755906), true);
      AppMethodBeat.o(12764);
      return;
    }
    Toast.makeText(this, "err :" + paramInt1 + " ," + paramInt2, 0).show();
    AppMethodBeat.o(12764);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomRightUI
 * JD-Core Version:    0.7.0.1
 */