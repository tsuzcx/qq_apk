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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.c.a;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LuckyMoneyExclusiveSelectContactUI
  extends MMBaseSelectContactUI
{
  private String chatroomName;
  private List<String> gzY;
  private List<String> jWf;
  
  public LuckyMoneyExclusiveSelectContactUI()
  {
    AppMethodBeat.i(213404);
    this.gzY = new ArrayList();
    this.jWf = new ArrayList();
    AppMethodBeat.o(213404);
  }
  
  public final void M(final View paramView, int paramInt)
  {
    AppMethodBeat.i(213407);
    Log.i("MicroMsg.LuckyMoneyExclusiveSelectContactUI", "handleItemClick: %s", new Object[] { Integer.valueOf(paramInt) });
    paramView = gUP().anH(paramInt - getContentLV().getHeaderViewsCount());
    if (paramView == null)
    {
      AppMethodBeat.o(213407);
      return;
    }
    if (paramView.contact == null)
    {
      AppMethodBeat.o(213407);
      return;
    }
    Log.i("MicroMsg.LuckyMoneyExclusiveSelectContactUI", "ClickUser=%s", new Object[] { paramView.contact.field_username });
    Object localObject = paramView.contact.field_username;
    String str1 = aa.getDisplayName((String)localObject, this.chatroomName);
    Iterator localIterator = this.jWf.iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if ((!str2.equals(localObject)) && (str1.equals(aa.getDisplayName(str2, this.chatroomName)))) {
        Log.i("MicroMsg.LuckyMoneyExclusiveSelectContactUI", "find same display name: %s", new Object[] { str1 });
      }
    }
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      h.a(getContext(), getString(2131762627), "", false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(213398);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("Select_Contact", paramView.contact.field_username);
          LuckyMoneyExclusiveSelectContactUI.this.setResult(-1, paramAnonymousDialogInterface);
          LuckyMoneyExclusiveSelectContactUI.this.finish();
          AppMethodBeat.o(213398);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(213407);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("Select_Contact", paramView.contact.field_username);
    setResult(-1, (Intent)localObject);
    finish();
    AppMethodBeat.o(213407);
  }
  
  public final boolean bmA()
  {
    return true;
  }
  
  public final String bmB()
  {
    AppMethodBeat.i(213406);
    String str = getString(2131762668);
    AppMethodBeat.o(213406);
    return str;
  }
  
  public final q bmC()
  {
    AppMethodBeat.i(213408);
    Object localObject = new c.a();
    ((c.a)localObject).PTX = Util.listToString(this.jWf, ",");
    ((c.a)localObject).dFl = this.chatroomName;
    ((c.a)localObject).PTS = true;
    localObject = new com.tencent.mm.ui.contact.c(this, this.gzY, false, (c.a)localObject, (byte)0);
    AppMethodBeat.o(213408);
    return localObject;
  }
  
  public final o bmD()
  {
    AppMethodBeat.i(213409);
    a locala = new a(this, this.gzY, this.chatroomName);
    AppMethodBeat.o(213409);
    return locala;
  }
  
  public final boolean bmz()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(213405);
    this.chatroomName = getIntent().getStringExtra("chatroomName");
    this.gzY.add(z.aTY());
    this.jWf = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kh(this.chatroomName);
    this.jWf.remove(z.aTY());
    super.onCreate(paramBundle);
    AppMethodBeat.o(213405);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
    extends s
  {
    private String chatroomName;
    private Cursor jWh;
    private String[] jWi;
    private String query;
    
    public a(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, String paramString)
    {
      super(paramList, false, paramMMBaseSelectContactUI.scene);
      AppMethodBeat.i(213399);
      this.chatroomName = paramString;
      paramMMBaseSelectContactUI = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kh(this.chatroomName);
      if (paramMMBaseSelectContactUI != null)
      {
        paramMMBaseSelectContactUI.remove(z.aTY());
        this.jWi = Util.listToStrings(paramMMBaseSelectContactUI);
      }
      AppMethodBeat.o(213399);
    }
    
    public final void b(String paramString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(213400);
      Log.i("MicroMsg.SelectSearchContactItemByChatroom", "doSearch: %s", new Object[] { paramString });
      clearCache();
      this.query = paramString;
      if (this.jWh != null)
      {
        this.jWh.close();
        this.jWh = null;
      }
      paramArrayOfInt = new ArrayList();
      paramArrayOfInt.add(z.aTY());
      if ((!Util.isNullOrNil(this.query)) && (this.jWi != null))
      {
        g.aAi();
        this.jWh = ((l)g.af(l.class)).aSN().a(this.jWi, "@all.chatroom", this.query, new LinkedList(), paramArrayOfInt);
      }
      notifyDataSetChanged();
      ds(paramString, true);
      AppMethodBeat.o(213400);
    }
    
    public final void finish()
    {
      AppMethodBeat.i(213402);
      super.finish();
      if (this.jWh != null)
      {
        this.jWh.close();
        this.jWh = null;
      }
      AppMethodBeat.o(213402);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(213403);
      if (this.jWh == null)
      {
        AppMethodBeat.o(213403);
        return 0;
      }
      int i = this.jWh.getCount();
      AppMethodBeat.o(213403);
      return i;
    }
    
    public final a va(int paramInt)
    {
      AppMethodBeat.i(213401);
      Object localObject = null;
      if (this.jWh.moveToPosition(paramInt))
      {
        as localas = new as();
        localas.convertFrom(this.jWh);
        e locale = new e(paramInt);
        locale.contact = localas;
        localObject = locale;
        if (as.bjp(localas.field_username))
        {
          locale.Qab = true;
          localObject = locale;
        }
      }
      AppMethodBeat.o(213401);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyExclusiveSelectContactUI
 * JD-Core Version:    0.7.0.1
 */