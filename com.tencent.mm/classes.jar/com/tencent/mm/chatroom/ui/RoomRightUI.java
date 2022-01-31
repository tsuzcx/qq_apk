package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class RoomRightUI
  extends MMPreference
  implements com.tencent.mm.ai.f
{
  private ProgressDialog eeN = null;
  private String ehF = "";
  private int ehG = 0;
  private com.tencent.mm.ui.base.preference.f screen;
  
  private void Ka()
  {
    AppMethodBeat.i(104208);
    int i = bo.a((Integer)g.RL().Ru().get(135175, null), 0);
    Object localObject1 = this.screen.atx("settings_room_size");
    int j;
    if ((localObject1 != null) && (i > 0))
    {
      ((Preference)localObject1).setSummary(getResources().getQuantityString(2131361818, i, new Object[] { Integer.valueOf(i) }));
      ((Preference)localObject1).setEnabled(false);
      this.screen.atx("room_right_max_tip").setTitle(getString(2131302772, new Object[] { Integer.valueOf(i) }));
      j = bo.a((Integer)g.RL().Ru().get(135176, null), 0);
      localObject1 = (RoomGrantPreference)this.screen.atx("settings_room_grant");
      if ((localObject1 == null) || (j > 0)) {
        break label293;
      }
      this.screen.d((Preference)localObject1);
    }
    Preference localPreference;
    Object localObject2;
    for (;;)
    {
      localPreference = this.screen.atx("room_right_tip");
      localObject2 = this.screen.atx("room_right_grant_tip");
      if (j > 0) {
        break label359;
      }
      if (localPreference != null) {
        this.screen.d(localPreference);
      }
      if (localObject2 != null) {
        this.screen.d((Preference)localObject2);
      }
      localObject2 = this.screen.atx("room_grant_to_friend");
      if (localObject2 != null) {
        this.screen.d((Preference)localObject2);
      }
      if (localObject1 != null) {
        this.screen.d((Preference)localObject1);
      }
      AppMethodBeat.o(104208);
      return;
      if (localObject1 == null) {
        break;
      }
      this.screen.d((Preference)localObject1);
      break;
      label293:
      if (localObject1 != null)
      {
        ((RoomGrantPreference)localObject1).setEnabled(false);
        localObject2 = getString(2131302775, new Object[] { Integer.valueOf(j) });
        ((RoomGrantPreference)localObject1).ehy = ((String)localObject2);
        if (((RoomGrantPreference)localObject1).ehx != null) {
          ((RoomGrantPreference)localObject1).ehx.setText((CharSequence)localObject2);
        }
      }
    }
    label359:
    localObject1 = getString(2131302776, new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    if (localPreference != null) {
      localPreference.setTitle((CharSequence)localObject1);
    }
    localObject1 = getString(2131302769, new Object[] { Integer.valueOf(this.ehG) });
    if (localObject2 != null) {
      ((Preference)localObject2).setTitle((CharSequence)localObject1);
    }
    AppMethodBeat.o(104208);
  }
  
  private void a(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(104215);
    if (paramLinkedList.size() > 0) {}
    String str;
    LinkedList localLinkedList;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      str = ah.getContext().getString(2131298140);
      paramLinkedList.size();
      localLinkedList = new LinkedList();
      if (!g.RG()) {
        break;
      }
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext()) {
        localLinkedList.add(s.nE((String)localIterator.next()));
      }
    }
    h.a(this, getString(2131302773, new Object[] { bo.d(localLinkedList, str) }), getString(2131297087), new RoomRightUI.3(this, paramLinkedList));
    AppMethodBeat.o(104215);
  }
  
  public int getResourceId()
  {
    return 2131165262;
  }
  
  public void initView()
  {
    AppMethodBeat.i(104213);
    this.screen = getPreferenceScreen();
    setMMTitle(2131303408);
    setBackBtn(new RoomRightUI.1(this));
    AppMethodBeat.o(104213);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(104214);
    ab.i("MicroMsg.RoomRightUI", "onAcvityResult requestCode: %d", new Object[] { Integer.valueOf(paramInt1) });
    if ((paramInt2 != -1) || (paramIntent == null))
    {
      AppMethodBeat.o(104214);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(104214);
      return;
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      ab.d("MicroMsg.RoomRightUI", "pick user %s", new Object[] { paramIntent });
      if (bo.isNullOrNil(paramIntent))
      {
        AppMethodBeat.o(104214);
        return;
      }
      this.ehF = paramIntent;
      paramIntent = this.ehF;
      String str = getString(2131302706, new Object[] { ((j)g.E(j.class)).YA().arw(paramIntent).Of(), Integer.valueOf(this.ehG) });
      h.a(getContext(), str, "", new RoomRightUI.2(this, paramIntent), null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104209);
    super.onCreate(paramBundle);
    this.ehG = bo.a((Integer)g.RL().Ru().get(135177, null), 0);
    g.RK().eHt.a(339, this);
    g.RK().eHt.a(30, this);
    g.RL().Ru().set(135184, Boolean.FALSE);
    initView();
    AppMethodBeat.o(104209);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104212);
    super.onDestroy();
    g.RK().eHt.b(339, this);
    g.RK().eHt.b(30, this);
    AppMethodBeat.o(104212);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(104211);
    if (paramPreference.mKey.equals("room_grant_to_friend"))
    {
      paramf = new Intent();
      paramf.setClassName(ah.getPackageName(), ah.getPackageName() + ".ui.contact.SelectContactUI");
      paramf.putExtra("Contact_GroupFilter_Type", "@all.contact.without.chatroom");
      paramf.putExtra("List_Type", 4);
      paramf.putExtra("select_contact_pick_result", true);
      paramPreference = new LinkedList();
      paramPreference.add("officialaccounts");
      paramf.putExtra("Block_list", bo.d(paramPreference, ","));
      paramf.putExtra("Add_SendCard", true);
      paramf.putExtra("is_multi_select", false);
      startActivityForResult(paramf, 1);
    }
    AppMethodBeat.o(104211);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(104210);
    super.onResume();
    Ka();
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(104210);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(104216);
    ab.i("MicroMsg.RoomRightUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.eeN != null) {
      this.eeN.dismiss();
    }
    if (paramm.getType() != 339)
    {
      AppMethodBeat.o(104216);
      return;
    }
    paramString = ((j)g.E(j.class)).YA().arw(this.ehF);
    if ((paramString == null) || ((int)paramString.euF == 0)) {}
    for (paramString = this.ehF; (paramInt1 == 0) && (paramInt2 == 0); paramString = paramString.Of())
    {
      h.b(this, getString(2131302709, new Object[] { paramString }), getString(2131297087), true);
      if (this.screen != null)
      {
        Ka();
        this.screen.notifyDataSetChanged();
      }
      AppMethodBeat.o(104216);
      return;
    }
    if (paramInt2 == -251)
    {
      h.b(this, getString(2131302707, new Object[] { paramString, Integer.valueOf(this.ehG) }), getString(2131297087), true);
      AppMethodBeat.o(104216);
      return;
    }
    if (paramInt2 == -44)
    {
      paramString = new LinkedList();
      paramString.add(this.ehF);
      a(paramString);
      AppMethodBeat.o(104216);
      return;
    }
    if (paramInt2 == -22)
    {
      h.b(this, getString(2131302708, new Object[] { paramString }), getString(2131297087), true);
      AppMethodBeat.o(104216);
      return;
    }
    Toast.makeText(this, "err :" + paramInt1 + " ," + paramInt2, 0).show();
    AppMethodBeat.o(104216);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomRightUI
 * JD-Core Version:    0.7.0.1
 */