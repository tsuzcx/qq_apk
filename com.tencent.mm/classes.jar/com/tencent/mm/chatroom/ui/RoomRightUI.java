package com.tencent.mm.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.applet.ab.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class RoomRightUI
  extends MMPreference
  implements com.tencent.mm.am.h
{
  private String lKX = "";
  private int lKY = 0;
  private ProgressDialog lzP = null;
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
      i = a.i.lIJ;
      localLinkedList = new LinkedList();
      if (!com.tencent.mm.kernel.h.baz()) {
        break;
      }
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext()) {
        localLinkedList.add(aa.getDisplayName((String)localIterator.next()));
      }
    }
    k.d(this, getString(i, new Object[] { Util.listToString(localLinkedList, str) }), getString(a.i.app_tip), new DialogInterface.OnClickListener()
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
  
  private void aMZ()
  {
    AppMethodBeat.i(12756);
    int i = Util.nullAs((Integer)com.tencent.mm.kernel.h.baE().ban().d(135175, null), 0);
    Object localObject1 = this.screen.bAi("settings_room_size");
    int j;
    if ((localObject1 != null) && (i > 0))
    {
      ((Preference)localObject1).aS(getResources().getQuantityString(a.g.lGH, i, new Object[] { Integer.valueOf(i) }));
      ((Preference)localObject1).setEnabled(false);
      this.screen.bAi("room_right_max_tip").setTitle(getString(a.i.lII, new Object[] { Integer.valueOf(i) }));
      j = Util.nullAs((Integer)com.tencent.mm.kernel.h.baE().ban().d(135176, null), 0);
      localObject1 = (RoomGrantPreference)this.screen.bAi("settings_room_grant");
      if ((localObject1 == null) || (j > 0)) {
        break label297;
      }
      this.screen.e((Preference)localObject1);
    }
    Preference localPreference;
    Object localObject2;
    for (;;)
    {
      localPreference = this.screen.bAi("room_right_tip");
      localObject2 = this.screen.bAi("room_right_grant_tip");
      if (j > 0) {
        break label364;
      }
      if (localPreference != null) {
        this.screen.e(localPreference);
      }
      if (localObject2 != null) {
        this.screen.e((Preference)localObject2);
      }
      localObject2 = this.screen.bAi("room_grant_to_friend");
      if (localObject2 != null) {
        this.screen.e((Preference)localObject2);
      }
      if (localObject1 != null) {
        this.screen.e((Preference)localObject1);
      }
      AppMethodBeat.o(12756);
      return;
      if (localObject1 == null) {
        break;
      }
      this.screen.e((Preference)localObject1);
      break;
      label297:
      if (localObject1 != null)
      {
        ((RoomGrantPreference)localObject1).setEnabled(false);
        localObject2 = getString(a.i.lIK, new Object[] { Integer.valueOf(j) });
        ((RoomGrantPreference)localObject1).num = ((String)localObject2);
        if (((RoomGrantPreference)localObject1).lKQ != null) {
          ((RoomGrantPreference)localObject1).lKQ.setText((CharSequence)localObject2);
        }
      }
    }
    label364:
    localObject1 = getString(a.i.lIL, new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    if (localPreference != null) {
      localPreference.setTitle((CharSequence)localObject1);
    }
    localObject1 = getString(a.i.lIH, new Object[] { Integer.valueOf(this.lKY) });
    if (localObject2 != null) {
      ((Preference)localObject2).setTitle((CharSequence)localObject1);
    }
    AppMethodBeat.o(12756);
  }
  
  public int getResourceId()
  {
    return a.k.lJW;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12761);
    this.screen = getPreferenceScreen();
    setMMTitle(a.i.lJr);
    setBackBtn(new RoomRightUI.1(this));
    AppMethodBeat.o(12761);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
      this.lKX = paramIntent;
      paramIntent = this.lKX;
      Object localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramIntent);
      localObject = getString(a.i.lIl, new Object[] { ((d)localObject).aSV(), Integer.valueOf(this.lKY) });
      k.a(getContext(), (String)localObject, "", new RoomRightUI.2(this, paramIntent), null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12757);
    super.onCreate(paramBundle);
    this.lKY = Util.nullAs((Integer)com.tencent.mm.kernel.h.baE().ban().d(135177, null), 0);
    com.tencent.mm.kernel.h.baD().mCm.a(339, this);
    com.tencent.mm.kernel.h.baD().mCm.a(30, this);
    com.tencent.mm.kernel.h.baE().ban().B(135184, Boolean.FALSE);
    initView();
    AppMethodBeat.o(12757);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12760);
    super.onDestroy();
    com.tencent.mm.kernel.h.baD().mCm.b(339, this);
    com.tencent.mm.kernel.h.baD().mCm.b(30, this);
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
    aMZ();
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(12758);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(12764);
    Log.i("MicroMsg.RoomRightUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.lzP != null) {
      this.lzP.dismiss();
    }
    if (paramp.getType() != 339)
    {
      AppMethodBeat.o(12764);
      return;
    }
    paramString = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(this.lKX);
    if ((paramString == null) || ((int)paramString.maN == 0)) {}
    for (paramString = this.lKX; (paramInt1 == 0) && (paramInt2 == 0); paramString = paramString.aSV())
    {
      k.c(this, getString(a.i.lIo, new Object[] { paramString }), getString(a.i.app_tip), true);
      if (this.screen != null)
      {
        aMZ();
        this.screen.notifyDataSetChanged();
      }
      AppMethodBeat.o(12764);
      return;
    }
    if (paramInt2 == -251)
    {
      k.c(this, getString(a.i.lIm, new Object[] { paramString, Integer.valueOf(this.lKY) }), getString(a.i.app_tip), true);
      AppMethodBeat.o(12764);
      return;
    }
    if (paramInt2 == -44)
    {
      paramString = new LinkedList();
      paramString.add(this.lKX);
      a(paramString);
      AppMethodBeat.o(12764);
      return;
    }
    if (paramInt2 == -22)
    {
      k.c(this, getString(a.i.lIn, new Object[] { paramString }), getString(a.i.app_tip), true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomRightUI
 * JD-Core Version:    0.7.0.1
 */