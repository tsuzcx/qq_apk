package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
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
  private List<String> jkb;
  private List<String> mNr;
  
  public LuckyMoneyExclusiveSelectContactUI()
  {
    AppMethodBeat.i(272735);
    this.jkb = new ArrayList();
    this.mNr = new ArrayList();
    AppMethodBeat.o(272735);
  }
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(272740);
    Log.i("MicroMsg.LuckyMoneyExclusiveSelectContactUI", "handleItemClick: %s", new Object[] { Integer.valueOf(paramInt) });
    final a locala = hUP().awM(paramInt - getContentLV().getHeaderViewsCount());
    if (locala == null)
    {
      AppMethodBeat.o(272740);
      return;
    }
    if (locala.contact == null)
    {
      AppMethodBeat.o(272740);
      return;
    }
    Log.i("MicroMsg.LuckyMoneyExclusiveSelectContactUI", "ClickUser=%s", new Object[] { locala.contact.field_username });
    paramView = locala.contact.field_username;
    String str1 = aa.aL(paramView, this.chatroomName);
    Iterator localIterator = this.mNr.iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if ((!str2.equals(paramView)) && (str1.equals(aa.aL(str2, this.chatroomName)))) {
        Log.i("MicroMsg.LuckyMoneyExclusiveSelectContactUI", "find same display name: %s", new Object[] { str1 });
      }
    }
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      str1 = getIntent().getStringExtra("key_same_name_tips");
      paramView = str1;
      if (Util.isNullOrNil(str1)) {
        paramView = getString(a.i.lucky_money_exclusive_same_displayname_tips);
      }
      com.tencent.mm.ui.base.h.a(getContext(), paramView, "", false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(204737);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("Select_Contact", locala.contact.field_username);
          LuckyMoneyExclusiveSelectContactUI.this.setResult(-1, paramAnonymousDialogInterface);
          LuckyMoneyExclusiveSelectContactUI.this.finish();
          AppMethodBeat.o(204737);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(272740);
      return;
    }
    paramView = new Intent();
    paramView.putExtra("Select_Contact", locala.contact.field_username);
    setResult(-1, paramView);
    finish();
    AppMethodBeat.o(272740);
  }
  
  public final boolean bwH()
  {
    return false;
  }
  
  public final boolean bwI()
  {
    return true;
  }
  
  public final String bwJ()
  {
    AppMethodBeat.i(272739);
    String str = getIntent().getStringExtra("key_title");
    if (!Util.isNullOrNil(str))
    {
      AppMethodBeat.o(272739);
      return str;
    }
    str = getString(a.i.lucky_money_mode_select_exclusive_user_title_text);
    AppMethodBeat.o(272739);
    return str;
  }
  
  public final r bwK()
  {
    AppMethodBeat.i(272742);
    Object localObject = new c.a();
    ((c.a)localObject).XqI = Util.listToString(this.mNr, ",");
    ((c.a)localObject).fxT = this.chatroomName;
    ((c.a)localObject).XqD = true;
    localObject = new c(this, this.jkb, false, (c.a)localObject, (byte)0);
    AppMethodBeat.o(272742);
    return localObject;
  }
  
  public final p bwL()
  {
    AppMethodBeat.i(272744);
    a locala = new a(this, this.jkb, this.chatroomName);
    AppMethodBeat.o(272744);
    return locala;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(272737);
    this.chatroomName = getIntent().getStringExtra("chatroomName");
    this.jkb.add(z.bcZ());
    this.mNr = ((b)com.tencent.mm.kernel.h.ae(b.class)).bbV().RA(this.chatroomName);
    this.mNr.remove(z.bcZ());
    super.onCreate(paramBundle);
    AppMethodBeat.o(272737);
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
    private Cursor mNt;
    private String[] mNu;
    private String query;
    
    public a(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, String paramString)
    {
      super(paramList, false, paramMMBaseSelectContactUI.scene);
      AppMethodBeat.i(273072);
      this.chatroomName = paramString;
      paramMMBaseSelectContactUI = ((b)com.tencent.mm.kernel.h.ae(b.class)).bbV().RA(this.chatroomName);
      if (paramMMBaseSelectContactUI != null)
      {
        paramMMBaseSelectContactUI.remove(z.bcZ());
        this.mNu = Util.listToStrings(paramMMBaseSelectContactUI);
      }
      AppMethodBeat.o(273072);
    }
    
    public final void a(String paramString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(273073);
      Log.i("MicroMsg.SelectSearchContactItemByChatroom", "doSearch: %s", new Object[] { paramString });
      clearCache();
      this.query = paramString;
      if (this.mNt != null)
      {
        this.mNt.close();
        this.mNt = null;
      }
      paramArrayOfInt = new ArrayList();
      paramArrayOfInt.add(z.bcZ());
      if ((!Util.isNullOrNil(this.query)) && (this.mNu != null))
      {
        com.tencent.mm.kernel.h.aHH();
        this.mNt = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().a(this.mNu, "@all.chatroom", this.query, new LinkedList(), paramArrayOfInt);
      }
      notifyDataSetChanged();
      dE(paramString, true);
      AppMethodBeat.o(273073);
    }
    
    public final void finish()
    {
      AppMethodBeat.i(273075);
      super.finish();
      if (this.mNt != null)
      {
        this.mNt.close();
        this.mNt = null;
      }
      AppMethodBeat.o(273075);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(273076);
      if (this.mNt == null)
      {
        AppMethodBeat.o(273076);
        return 0;
      }
      int i = this.mNt.getCount();
      AppMethodBeat.o(273076);
      return i;
    }
    
    public final a ye(int paramInt)
    {
      AppMethodBeat.i(273074);
      Object localObject = null;
      if (this.mNt.moveToPosition(paramInt))
      {
        as localas = new as();
        localas.convertFrom(this.mNt);
        f localf = new f(paramInt);
        localf.contact = localas;
        localObject = localf;
        if (as.bvK(localas.field_username))
        {
          localf.Xxt = true;
          localObject = localf;
        }
      }
      AppMethodBeat.o(273074);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyExclusiveSelectContactUI
 * JD-Core Version:    0.7.0.1
 */