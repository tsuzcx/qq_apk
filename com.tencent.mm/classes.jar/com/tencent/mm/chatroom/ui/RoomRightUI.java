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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.chatroom.d.o;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.applet.aa.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class RoomRightUI
  extends MMPreference
  implements i
{
  private ProgressDialog iXX = null;
  private String jiD = "";
  private int jiE = 0;
  private com.tencent.mm.ui.base.preference.f screen;
  
  private void a(final LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(12763);
    if (paramLinkedList.size() > 0) {}
    String str;
    int i;
    LinkedList localLinkedList;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      str = MMApplicationContext.getContext().getString(a.i.chatroom_sys_msg_invite_split);
      paramLinkedList.size();
      i = a.i.jgw;
      localLinkedList = new LinkedList();
      if (!com.tencent.mm.kernel.h.aHB()) {
        break;
      }
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext()) {
        localLinkedList.add(aa.PJ((String)localIterator.next()));
      }
    }
    com.tencent.mm.ui.base.h.d(this, getString(i, new Object[] { Util.listToString(localLinkedList, str) }), getString(a.i.app_tip), new DialogInterface.OnClickListener()
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
  
  private void asY()
  {
    AppMethodBeat.i(12756);
    int i = Util.nullAs((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(135175, null), 0);
    Object localObject1 = this.screen.byG("settings_room_size");
    int j;
    if ((localObject1 != null) && (i > 0))
    {
      ((Preference)localObject1).aF(getResources().getQuantityString(a.g.jew, i, new Object[] { Integer.valueOf(i) }));
      ((Preference)localObject1).setEnabled(false);
      this.screen.byG("room_right_max_tip").setTitle(getString(a.i.jgv, new Object[] { Integer.valueOf(i) }));
      j = Util.nullAs((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(135176, null), 0);
      localObject1 = (RoomGrantPreference)this.screen.byG("settings_room_grant");
      if ((localObject1 == null) || (j > 0)) {
        break label297;
      }
      this.screen.d((Preference)localObject1);
    }
    Preference localPreference;
    Object localObject2;
    for (;;)
    {
      localPreference = this.screen.byG("room_right_tip");
      localObject2 = this.screen.byG("room_right_grant_tip");
      if (j > 0) {
        break label364;
      }
      if (localPreference != null) {
        this.screen.d(localPreference);
      }
      if (localObject2 != null) {
        this.screen.d((Preference)localObject2);
      }
      localObject2 = this.screen.byG("room_grant_to_friend");
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
      label297:
      if (localObject1 != null)
      {
        ((RoomGrantPreference)localObject1).setEnabled(false);
        localObject2 = getString(a.i.jgx, new Object[] { Integer.valueOf(j) });
        ((RoomGrantPreference)localObject1).num = ((String)localObject2);
        if (((RoomGrantPreference)localObject1).jiw != null) {
          ((RoomGrantPreference)localObject1).jiw.setText((CharSequence)localObject2);
        }
      }
    }
    label364:
    localObject1 = getString(a.i.jgy, new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    if (localPreference != null) {
      localPreference.setTitle((CharSequence)localObject1);
    }
    localObject1 = getString(a.i.jgu, new Object[] { Integer.valueOf(this.jiE) });
    if (localObject2 != null) {
      ((Preference)localObject2).setTitle((CharSequence)localObject1);
    }
    AppMethodBeat.o(12756);
  }
  
  public int getResourceId()
  {
    return a.k.jhG;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12761);
    this.screen = getPreferenceScreen();
    setMMTitle(a.i.jhb);
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
    Log.i("MicroMsg.RoomRightUI", "onAcvityResult requestCode: %d", new Object[] { Integer.valueOf(paramInt1) });
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
      Log.d("MicroMsg.RoomRightUI", "pick user %s", new Object[] { paramIntent });
      if (Util.isNullOrNil(paramIntent))
      {
        AppMethodBeat.o(12762);
        return;
      }
      this.jiD = paramIntent;
      paramIntent = this.jiD;
      Object localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramIntent);
      localObject = getString(a.i.jfY, new Object[] { ((d)localObject).ays(), Integer.valueOf(this.jiE) });
      com.tencent.mm.ui.base.h.a(getContext(), (String)localObject, "", new DialogInterface.OnClickListener()
      {
        public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(12754);
          paramAnonymousDialogInterface = new o(paramIntent);
          RoomRightUI localRoomRightUI1 = RoomRightUI.this;
          RoomRightUI localRoomRightUI2 = RoomRightUI.this;
          RoomRightUI.this.getString(a.i.app_tip);
          RoomRightUI.a(localRoomRightUI1, com.tencent.mm.ui.base.h.a(localRoomRightUI2, "", true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(12753);
              com.tencent.mm.kernel.h.aHF().kcd.a(paramAnonymousDialogInterface);
              AppMethodBeat.o(12753);
            }
          }));
          com.tencent.mm.kernel.h.aHF().kcd.a(paramAnonymousDialogInterface, 0);
          AppMethodBeat.o(12754);
        }
      }, null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12757);
    super.onCreate(paramBundle);
    this.jiE = Util.nullAs((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(135177, null), 0);
    com.tencent.mm.kernel.h.aHF().kcd.a(339, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(30, this);
    com.tencent.mm.kernel.h.aHG().aHp().i(135184, Boolean.FALSE);
    initView();
    AppMethodBeat.o(12757);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12760);
    super.onDestroy();
    com.tencent.mm.kernel.h.aHF().kcd.b(339, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(30, this);
    AppMethodBeat.o(12760);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(12759);
    if (paramPreference.mKey.equals("room_grant_to_friend"))
    {
      paramf = new Intent();
      paramf.setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".ui.contact.SelectContactUI");
      paramf.putExtra("Contact_GroupFilter_Type", "@all.contact.without.chatroom");
      paramf.putExtra("List_Type", 4);
      paramf.putExtra("select_contact_pick_result", true);
      paramPreference = new LinkedList();
      paramPreference.add("officialaccounts");
      paramf.putExtra("Block_list", Util.listToString(paramPreference, ","));
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
    asY();
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(12758);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(12764);
    Log.i("MicroMsg.RoomRightUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.iXX != null) {
      this.iXX.dismiss();
    }
    if (paramq.getType() != 339)
    {
      AppMethodBeat.o(12764);
      return;
    }
    paramString = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(this.jiD);
    if ((paramString == null) || ((int)paramString.jxt == 0)) {}
    for (paramString = this.jiD; (paramInt1 == 0) && (paramInt2 == 0); paramString = paramString.ays())
    {
      com.tencent.mm.ui.base.h.c(this, getString(a.i.jgb, new Object[] { paramString }), getString(a.i.app_tip), true);
      if (this.screen != null)
      {
        asY();
        this.screen.notifyDataSetChanged();
      }
      AppMethodBeat.o(12764);
      return;
    }
    if (paramInt2 == -251)
    {
      com.tencent.mm.ui.base.h.c(this, getString(a.i.jfZ, new Object[] { paramString, Integer.valueOf(this.jiE) }), getString(a.i.app_tip), true);
      AppMethodBeat.o(12764);
      return;
    }
    if (paramInt2 == -44)
    {
      paramString = new LinkedList();
      paramString.add(this.jiD);
      a(paramString);
      AppMethodBeat.o(12764);
      return;
    }
    if (paramInt2 == -22)
    {
      com.tencent.mm.ui.base.h.c(this, getString(a.i.jga, new Object[] { paramString }), getString(a.i.app_tip), true);
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