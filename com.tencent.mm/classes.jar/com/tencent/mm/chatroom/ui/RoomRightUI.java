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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.chatroom.d.o;
import com.tencent.mm.contact.c;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.aa.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bv;
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
  implements i
{
  private ProgressDialog gtM = null;
  private String gyA = "";
  private int gyB = 0;
  private f screen;
  
  private void a(final LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(12763);
    if (paramLinkedList.size() > 0) {}
    String str;
    LinkedList localLinkedList;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      str = MMApplicationContext.getContext().getString(2131757307);
      paramLinkedList.size();
      localLinkedList = new LinkedList();
      if (!g.aAc()) {
        break;
      }
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext()) {
        localLinkedList.add(aa.getDisplayName((String)localIterator.next()));
      }
    }
    h.d(this, getString(2131764768, new Object[] { Util.listToString(localLinkedList, str) }), getString(2131755998), new DialogInterface.OnClickListener()
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
  
  private void amX()
  {
    AppMethodBeat.i(12756);
    int i = Util.nullAs((Integer)g.aAh().azQ().get(135175, null), 0);
    Object localObject1 = this.screen.bmg("settings_room_size");
    int j;
    if ((localObject1 != null) && (i > 0))
    {
      ((Preference)localObject1).setSummary(getResources().getQuantityString(2131623964, i, new Object[] { Integer.valueOf(i) }));
      ((Preference)localObject1).setEnabled(false);
      this.screen.bmg("room_right_max_tip").setTitle(getString(2131764767, new Object[] { Integer.valueOf(i) }));
      j = Util.nullAs((Integer)g.aAh().azQ().get(135176, null), 0);
      localObject1 = (RoomGrantPreference)this.screen.bmg("settings_room_grant");
      if ((localObject1 == null) || (j > 0)) {
        break label295;
      }
      this.screen.e((Preference)localObject1);
    }
    Preference localPreference;
    Object localObject2;
    for (;;)
    {
      localPreference = this.screen.bmg("room_right_tip");
      localObject2 = this.screen.bmg("room_right_grant_tip");
      if (j > 0) {
        break label361;
      }
      if (localPreference != null) {
        this.screen.e(localPreference);
      }
      if (localObject2 != null) {
        this.screen.e((Preference)localObject2);
      }
      localObject2 = this.screen.bmg("room_grant_to_friend");
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
      label295:
      if (localObject1 != null)
      {
        ((RoomGrantPreference)localObject1).setEnabled(false);
        localObject2 = getString(2131764770, new Object[] { Integer.valueOf(j) });
        ((RoomGrantPreference)localObject1).num = ((String)localObject2);
        if (((RoomGrantPreference)localObject1).gyt != null) {
          ((RoomGrantPreference)localObject1).gyt.setText((CharSequence)localObject2);
        }
      }
    }
    label361:
    localObject1 = getString(2131764771, new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    if (localPreference != null) {
      localPreference.setTitle((CharSequence)localObject1);
    }
    localObject1 = getString(2131764764, new Object[] { Integer.valueOf(this.gyB) });
    if (localObject2 != null) {
      ((Preference)localObject2).setTitle((CharSequence)localObject1);
    }
    AppMethodBeat.o(12756);
  }
  
  public int getResourceId()
  {
    return 2132017250;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12761);
    this.screen = getPreferenceScreen();
    setMMTitle(2131765572);
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
      this.gyA = paramIntent;
      paramIntent = this.gyA;
      String str = getString(2131764699, new Object[] { ((l)g.af(l.class)).aSN().Kn(paramIntent).arJ(), Integer.valueOf(this.gyB) });
      h.a(getContext(), str, "", new DialogInterface.OnClickListener()
      {
        public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(12754);
          paramAnonymousDialogInterface = new o(paramIntent);
          RoomRightUI localRoomRightUI1 = RoomRightUI.this;
          RoomRightUI localRoomRightUI2 = RoomRightUI.this;
          RoomRightUI.this.getString(2131755998);
          RoomRightUI.a(localRoomRightUI1, h.a(localRoomRightUI2, "", true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(12753);
              g.aAg().hqi.a(paramAnonymousDialogInterface);
              AppMethodBeat.o(12753);
            }
          }));
          g.aAg().hqi.a(paramAnonymousDialogInterface, 0);
          AppMethodBeat.o(12754);
        }
      }, null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12757);
    super.onCreate(paramBundle);
    this.gyB = Util.nullAs((Integer)g.aAh().azQ().get(135177, null), 0);
    g.aAg().hqi.a(339, this);
    g.aAg().hqi.a(30, this);
    g.aAh().azQ().set(135184, Boolean.FALSE);
    initView();
    AppMethodBeat.o(12757);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12760);
    super.onDestroy();
    g.aAg().hqi.b(339, this);
    g.aAg().hqi.b(30, this);
    AppMethodBeat.o(12760);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
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
    amX();
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(12758);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(12764);
    Log.i("MicroMsg.RoomRightUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.gtM != null) {
      this.gtM.dismiss();
    }
    if (paramq.getType() != 339)
    {
      AppMethodBeat.o(12764);
      return;
    }
    paramString = ((l)g.af(l.class)).aSN().Kn(this.gyA);
    if ((paramString == null) || ((int)paramString.gMZ == 0)) {}
    for (paramString = this.gyA; (paramInt1 == 0) && (paramInt2 == 0); paramString = paramString.arJ())
    {
      h.c(this, getString(2131764702, new Object[] { paramString }), getString(2131755998), true);
      if (this.screen != null)
      {
        amX();
        this.screen.notifyDataSetChanged();
      }
      AppMethodBeat.o(12764);
      return;
    }
    if (paramInt2 == -251)
    {
      h.c(this, getString(2131764700, new Object[] { paramString, Integer.valueOf(this.gyB) }), getString(2131755998), true);
      AppMethodBeat.o(12764);
      return;
    }
    if (paramInt2 == -44)
    {
      paramString = new LinkedList();
      paramString.add(this.gyA);
      a(paramString);
      AppMethodBeat.o(12764);
      return;
    }
    if (paramInt2 == -22)
    {
      h.c(this, getString(2131764701, new Object[] { paramString }), getString(2131755998), true);
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