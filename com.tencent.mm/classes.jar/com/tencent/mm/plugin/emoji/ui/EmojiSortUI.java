package com.tencent.mm.plugin.emoji.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.emoji.a.e;
import com.tencent.mm.plugin.emoji.e.u;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmojiSortUI
  extends EmojiBaseActivity
  implements com.tencent.mm.am.h, MStorage.IOnStorageChange
{
  private ArrayList<EmojiGroupInfo> mlK;
  ProgressDialog pNH;
  private e xSJ;
  private DragSortListView xSK;
  private u xSL;
  private DragSortListView.h xSM;
  private DragSortListView.l xSN;
  
  public EmojiSortUI()
  {
    AppMethodBeat.i(108974);
    this.mlK = new ArrayList();
    this.xSM = new DragSortListView.h()
    {
      public final void drop(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(108972);
        EmojiGroupInfo localEmojiGroupInfo = (EmojiGroupInfo)EmojiSortUI.b(EmojiSortUI.this).getItem(paramAnonymousInt1);
        EmojiSortUI.b(EmojiSortUI.this).remove(localEmojiGroupInfo);
        EmojiSortUI.b(EmojiSortUI.this).insert(localEmojiGroupInfo, paramAnonymousInt2);
        AppMethodBeat.o(108972);
      }
    };
    this.xSN = new DragSortListView.l()
    {
      public final void remove(int paramAnonymousInt)
      {
        AppMethodBeat.i(108973);
        EmojiSortUI.b(EmojiSortUI.this).remove((EmojiGroupInfo)EmojiSortUI.b(EmojiSortUI.this).getItem(paramAnonymousInt));
        AppMethodBeat.o(108973);
      }
    };
    AppMethodBeat.o(108974);
  }
  
  public int getLayoutId()
  {
    return h.f.emoji_sort;
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
    setMMTitle(getString(h.h.settings_emoji_manager));
    addTextOptionMenu(0, getString(h.h.app_finish), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(108970);
        if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
          EmojiSortUI.a(EmojiSortUI.this);
        }
        for (;;)
        {
          AppMethodBeat.o(108970);
          return true;
          paramAnonymousMenuItem = EmojiSortUI.this;
          paramAnonymousMenuItem.getString(h.h.app_tip);
          paramAnonymousMenuItem.pNH = k.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(h.h.app_waiting), true, new EmojiSortUI.3(paramAnonymousMenuItem));
          paramAnonymousMenuItem = new ArrayList();
          if ((EmojiSortUI.b(EmojiSortUI.this) != null) && (EmojiSortUI.b(EmojiSortUI.this).xGG != null))
          {
            Iterator localIterator = EmojiSortUI.b(EmojiSortUI.this).xGG.iterator();
            while (localIterator.hasNext()) {
              paramAnonymousMenuItem.add(((EmojiGroupInfo)localIterator.next()).field_productID);
            }
          }
          EmojiSortUI.a(EmojiSortUI.this, new u(paramAnonymousMenuItem, 2));
          com.tencent.mm.kernel.h.baD().mCm.a(EmojiSortUI.c(EmojiSortUI.this), 0);
        }
      }
    });
    ((TextView)findViewById(16908310)).setText(h.h.emoji_store_manage_title);
    AppMethodBeat.o(108977);
  }
  
  public final void k(Message paramMessage) {}
  
  public final void l(Message paramMessage) {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108975);
    super.onCreate(paramBundle);
    initView();
    this.mlK = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.jdi();
    this.xSK = ((DragSortListView)findViewById(16908298));
    this.xSK.setDropListener(this.xSM);
    this.xSK.setRemoveListener(this.xSN);
    this.xSJ = new e(getContext(), this.mlK);
    this.xSK.setAdapter(this.xSJ);
    com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.add(this);
    com.tencent.mm.kernel.h.baD().mCm.a(717, this);
    AppMethodBeat.o(108975);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108976);
    com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.remove(this);
    com.tencent.mm.kernel.h.baD().mCm.b(717, this);
    super.onDestroy();
    AppMethodBeat.o(108976);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(108978);
    if ((paramString != null) && (paramString.equals("event_update_group")) && (this.xSJ != null))
    {
      paramString = this.xSJ;
      paramMStorageEventData = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.jdi();
      paramString.clear();
      if (paramMStorageEventData != null)
      {
        paramMStorageEventData = paramMStorageEventData.iterator();
        while (paramMStorageEventData.hasNext()) {
          paramString.insert((EmojiGroupInfo)paramMStorageEventData.next(), paramString.getCount());
        }
      }
      paramString.notifyDataSetChanged();
    }
    AppMethodBeat.o(108978);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(108979);
    Log.d("MicroMsg.emoji.EmojiSortUI", "ErrType:" + paramInt1 + "   errCode:" + paramInt2);
    if (this.pNH != null) {
      this.pNH.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt1 == 0))
    {
      this.xSJ.dyk();
      finish();
      AppMethodBeat.o(108979);
      return;
    }
    k.d(this, getString(h.h.emoji_sort_failed), "", new DialogInterface.OnClickListener()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiSortUI
 * JD-Core Version:    0.7.0.1
 */