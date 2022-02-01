package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.emoji.a.e;
import com.tencent.mm.plugin.emoji.f.s;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmojiSortUI
  extends EmojiBaseActivity
  implements com.tencent.mm.ak.g, k.a
{
  ProgressDialog iFC;
  private ArrayList<EmojiGroupInfo> mData;
  private e pfZ;
  private DragSortListView pga;
  private s pgb;
  private DragSortListView.h pgc;
  private DragSortListView.l pgd;
  
  public EmojiSortUI()
  {
    AppMethodBeat.i(108974);
    this.mData = new ArrayList();
    this.pgc = new DragSortListView.h()
    {
      public final void ei(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(108972);
        EmojiGroupInfo localEmojiGroupInfo = (EmojiGroupInfo)EmojiSortUI.b(EmojiSortUI.this).getItem(paramAnonymousInt1);
        EmojiSortUI.b(EmojiSortUI.this).remove(localEmojiGroupInfo);
        EmojiSortUI.b(EmojiSortUI.this).insert(localEmojiGroupInfo, paramAnonymousInt2);
        AppMethodBeat.o(108972);
      }
    };
    this.pgd = new DragSortListView.l()
    {
      public final void remove(int paramAnonymousInt)
      {
        AppMethodBeat.i(108973);
        EmojiSortUI.b(EmojiSortUI.this).remove(EmojiSortUI.b(EmojiSortUI.this).getItem(paramAnonymousInt));
        AppMethodBeat.o(108973);
      }
    };
    AppMethodBeat.o(108974);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(108978);
    if ((paramString != null) && (paramString.equals("event_update_group")) && (this.pfZ != null))
    {
      paramString = this.pfZ;
      paramm = k.getEmojiStorageMgr().GYa.fcX();
      paramString.clear();
      paramm = paramm.iterator();
      while (paramm.hasNext()) {
        paramString.insert((EmojiGroupInfo)paramm.next(), paramString.getCount());
      }
      paramString.notifyDataSetChanged();
    }
    AppMethodBeat.o(108978);
  }
  
  public int getLayoutId()
  {
    return 2131493790;
  }
  
  public void initView()
  {
    AppMethodBeat.i(108977);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(108969);
        EmojiSortUI.this.finish();
        AppMethodBeat.o(108969);
        return true;
      }
    });
    setMMTitle(getString(2131763213));
    addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(108970);
        if (!ax.isConnected(ai.getContext())) {
          EmojiSortUI.a(EmojiSortUI.this);
        }
        for (;;)
        {
          AppMethodBeat.o(108970);
          return true;
          paramAnonymousMenuItem = EmojiSortUI.this;
          paramAnonymousMenuItem.getString(2131755906);
          paramAnonymousMenuItem.iFC = h.b(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131755936), true, new EmojiSortUI.3(paramAnonymousMenuItem));
          paramAnonymousMenuItem = new ArrayList();
          if ((EmojiSortUI.b(EmojiSortUI.this) != null) && (EmojiSortUI.b(EmojiSortUI.this).oXp != null))
          {
            Iterator localIterator = EmojiSortUI.b(EmojiSortUI.this).oXp.iterator();
            while (localIterator.hasNext()) {
              paramAnonymousMenuItem.add(((EmojiGroupInfo)localIterator.next()).field_productID);
            }
          }
          EmojiSortUI.a(EmojiSortUI.this, new s(paramAnonymousMenuItem, 2));
          com.tencent.mm.kernel.g.agQ().ghe.a(EmojiSortUI.c(EmojiSortUI.this), 0);
        }
      }
    });
    ((TextView)findViewById(16908310)).setText(2131758335);
    AppMethodBeat.o(108977);
  }
  
  public final void l(Message paramMessage) {}
  
  public final void m(Message paramMessage) {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108975);
    super.onCreate(paramBundle);
    initView();
    this.mData = k.getEmojiStorageMgr().GYa.fcX();
    this.pga = ((DragSortListView)findViewById(16908298));
    this.pga.setDropListener(this.pgc);
    this.pga.setRemoveListener(this.pgd);
    this.pfZ = new e(getContext(), this.mData);
    this.pga.setAdapter(this.pfZ);
    k.getEmojiStorageMgr().GYa.add(this);
    com.tencent.mm.kernel.g.agQ().ghe.a(717, this);
    AppMethodBeat.o(108975);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108976);
    k.getEmojiStorageMgr().GYa.remove(this);
    com.tencent.mm.kernel.g.agQ().ghe.b(717, this);
    super.onDestroy();
    AppMethodBeat.o(108976);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(108979);
    ac.d("MicroMsg.emoji.EmojiSortUI", "ErrType:" + paramInt1 + "   errCode:" + paramInt2);
    if (this.iFC != null) {
      this.iFC.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt1 == 0))
    {
      this.pfZ.cbH();
      finish();
      AppMethodBeat.o(108979);
      return;
    }
    h.d(this, getString(2131758303), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(108979);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiSortUI
 * JD-Core Version:    0.7.0.1
 */