package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.c;
import com.tencent.mm.ui.contact.c.a;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.contact.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LuckyMoneyExclusiveSelectContactUI
  extends MMBaseSelectContactUI
{
  private String chatroomName;
  private List<String> lMF;
  private List<String> pJZ;
  
  public LuckyMoneyExclusiveSelectContactUI()
  {
    AppMethodBeat.i(284537);
    this.lMF = new ArrayList();
    this.pJZ = new ArrayList();
    AppMethodBeat.o(284537);
  }
  
  public final void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(284555);
    Log.i("MicroMsg.LuckyMoneyExclusiveSelectContactUI", "handleItemClick: %s", new Object[] { Integer.valueOf(paramInt) });
    final a locala = jyE().aDt(paramInt - getContentLV().getHeaderViewsCount());
    if (locala == null)
    {
      AppMethodBeat.o(284555);
      return;
    }
    if (locala.contact == null)
    {
      AppMethodBeat.o(284555);
      return;
    }
    Log.i("MicroMsg.LuckyMoneyExclusiveSelectContactUI", "ClickUser=%s", new Object[] { locala.contact.field_username });
    paramAdapterView = locala.contact.field_username;
    paramView = aa.aV(paramAdapterView, this.chatroomName);
    Iterator localIterator = this.pJZ.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!str.equals(paramAdapterView)) && (paramView.equals(aa.aV(str, this.chatroomName)))) {
        Log.i("MicroMsg.LuckyMoneyExclusiveSelectContactUI", "find same display name: %s", new Object[] { paramView });
      }
    }
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      paramView = getIntent().getStringExtra("key_same_name_tips");
      paramAdapterView = paramView;
      if (Util.isNullOrNil(paramView)) {
        paramAdapterView = getString(a.i.lucky_money_exclusive_same_displayname_tips);
      }
      k.a(getContext(), paramAdapterView, "", false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(284308);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("Select_Contact", locala.contact.field_username);
          LuckyMoneyExclusiveSelectContactUI.this.setResult(-1, paramAnonymousDialogInterface);
          LuckyMoneyExclusiveSelectContactUI.this.finish();
          AppMethodBeat.o(284308);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(284555);
      return;
    }
    paramAdapterView = new Intent();
    paramAdapterView.putExtra("Select_Contact", locala.contact.field_username);
    setResult(-1, paramAdapterView);
    finish();
    AppMethodBeat.o(284555);
  }
  
  public final r bVA()
  {
    AppMethodBeat.i(284557);
    Object localObject = new c.a();
    ((c.a)localObject).afcj = Util.listToString(this.pJZ, ",");
    ((c.a)localObject).hCy = this.chatroomName;
    ((c.a)localObject).afce = true;
    localObject = new c(this, this.lMF, false, (c.a)localObject, (byte)0);
    AppMethodBeat.o(284557);
    return localObject;
  }
  
  public final p bVB()
  {
    AppMethodBeat.i(284559);
    a locala = new a(this, this.lMF, this.chatroomName);
    AppMethodBeat.o(284559);
    return locala;
  }
  
  public final boolean bVx()
  {
    return false;
  }
  
  public final boolean bVy()
  {
    return true;
  }
  
  public final String bVz()
  {
    AppMethodBeat.i(284550);
    String str = getIntent().getStringExtra("key_title");
    if (!Util.isNullOrNil(str))
    {
      AppMethodBeat.o(284550);
      return str;
    }
    str = getString(a.i.lucky_money_mode_select_exclusive_user_title_text);
    AppMethodBeat.o(284550);
    return str;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(284542);
    this.chatroomName = getIntent().getStringExtra("chatroomName");
    this.lMF.add(z.bAM());
    this.pJZ = ((b)h.ax(b.class)).bzK().Jy(this.chatroomName);
    this.pJZ.remove(z.bAM());
    super.onCreate(paramBundle);
    AppMethodBeat.o(284542);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
    extends u
  {
    private String chatroomName;
    private Cursor pKb;
    private String[] pKc;
    private String query;
    
    public a(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, String paramString)
    {
      super(paramList, false, paramMMBaseSelectContactUI.scene);
      AppMethodBeat.i(284284);
      this.chatroomName = paramString;
      paramMMBaseSelectContactUI = ((b)h.ax(b.class)).bzK().Jy(this.chatroomName);
      if (paramMMBaseSelectContactUI != null)
      {
        paramMMBaseSelectContactUI.remove(z.bAM());
        this.pKc = Util.listToStrings(paramMMBaseSelectContactUI);
      }
      AppMethodBeat.o(284284);
    }
    
    public final void a(String paramString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(284287);
      Log.i("MicroMsg.SelectSearchContactItemByChatroom", "doSearch: %s", new Object[] { paramString });
      clearCache();
      this.query = paramString;
      if (this.pKb != null)
      {
        this.pKb.close();
        this.pKb = null;
      }
      paramArrayOfInt = new ArrayList();
      paramArrayOfInt.add(z.bAM());
      if ((!Util.isNullOrNil(this.query)) && (this.pKc != null))
      {
        h.baF();
        this.pKb = ((n)h.ax(n.class)).bzA().a(this.pKc, "@all.chatroom", this.query, new LinkedList(), paramArrayOfInt);
      }
      notifyDataSetChanged();
      eo(paramString, true);
      AppMethodBeat.o(284287);
    }
    
    public final void finish()
    {
      AppMethodBeat.i(284291);
      super.finish();
      if (this.pKb != null)
      {
        this.pKb.close();
        this.pKb = null;
      }
      AppMethodBeat.o(284291);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(284293);
      if (this.pKb == null)
      {
        AppMethodBeat.o(284293);
        return 0;
      }
      int i = this.pKb.getCount();
      AppMethodBeat.o(284293);
      return i;
    }
    
    public final a yk(int paramInt)
    {
      AppMethodBeat.i(284288);
      Object localObject = null;
      if (this.pKb.moveToPosition(paramInt))
      {
        au localau = new au();
        localau.convertFrom(this.pKb);
        f localf = new f(paramInt);
        localf.contact = localau;
        localObject = localf;
        if (au.bwO(localau.field_username))
        {
          localf.JXr = true;
          localObject = localf;
        }
      }
      AppMethodBeat.o(284288);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyExclusiveSelectContactUI
 * JD-Core Version:    0.7.0.1
 */