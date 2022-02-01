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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.emoji.a.e;
import com.tencent.mm.plugin.emoji.i.f;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmojiSortUI
  extends EmojiBaseActivity
  implements i, MStorage.IOnStorageChange
{
  private ArrayList<EmojiGroupInfo> mData;
  ProgressDialog mRa;
  private e uKo;
  private DragSortListView uKp;
  private com.tencent.mm.plugin.emoji.f.t uKq;
  private DragSortListView.h uKr;
  private DragSortListView.l uKs;
  
  public EmojiSortUI()
  {
    AppMethodBeat.i(108974);
    this.mData = new ArrayList();
    this.uKr = new DragSortListView.h()
    {
      public final void eX(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(108972);
        EmojiGroupInfo localEmojiGroupInfo = (EmojiGroupInfo)EmojiSortUI.b(EmojiSortUI.this).getItem(paramAnonymousInt1);
        EmojiSortUI.b(EmojiSortUI.this).remove(localEmojiGroupInfo);
        EmojiSortUI.b(EmojiSortUI.this).insert(localEmojiGroupInfo, paramAnonymousInt2);
        AppMethodBeat.o(108972);
      }
    };
    this.uKs = new DragSortListView.l()
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
  
  public int getLayoutId()
  {
    return i.f.emoji_sort;
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
    setMMTitle(getString(i.h.settings_emoji_manager));
    addTextOptionMenu(0, getString(i.h.app_finish), new MenuItem.OnMenuItemClickListener()
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
          paramAnonymousMenuItem.getString(i.h.app_tip);
          paramAnonymousMenuItem.mRa = com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(i.h.app_waiting), true, new EmojiSortUI.3(paramAnonymousMenuItem));
          paramAnonymousMenuItem = new ArrayList();
          if ((EmojiSortUI.b(EmojiSortUI.this) != null) && (EmojiSortUI.b(EmojiSortUI.this).uAd != null))
          {
            Iterator localIterator = EmojiSortUI.b(EmojiSortUI.this).uAd.iterator();
            while (localIterator.hasNext()) {
              paramAnonymousMenuItem.add(((EmojiGroupInfo)localIterator.next()).field_productID);
            }
          }
          EmojiSortUI.a(EmojiSortUI.this, new com.tencent.mm.plugin.emoji.f.t(paramAnonymousMenuItem, 2));
          com.tencent.mm.kernel.h.aHF().kcd.a(EmojiSortUI.c(EmojiSortUI.this), 0);
        }
      }
    });
    ((TextView)findViewById(16908310)).setText(i.h.emoji_store_manage_title);
    AppMethodBeat.o(108977);
  }
  
  public final void j(Message paramMessage) {}
  
  public final void k(Message paramMessage) {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108975);
    super.onCreate(paramBundle);
    initView();
    this.mData = p.getEmojiStorageMgr().VFI.hBh();
    this.uKp = ((DragSortListView)findViewById(16908298));
    this.uKp.setDropListener(this.uKr);
    this.uKp.setRemoveListener(this.uKs);
    this.uKo = new e(getContext(), this.mData);
    this.uKp.setAdapter(this.uKo);
    p.getEmojiStorageMgr().VFI.add(this);
    com.tencent.mm.kernel.h.aHF().kcd.a(717, this);
    AppMethodBeat.o(108975);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108976);
    p.getEmojiStorageMgr().VFI.remove(this);
    com.tencent.mm.kernel.h.aHF().kcd.b(717, this);
    super.onDestroy();
    AppMethodBeat.o(108976);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(108978);
    if ((paramString != null) && (paramString.equals("event_update_group")) && (this.uKo != null))
    {
      paramString = this.uKo;
      paramMStorageEventData = p.getEmojiStorageMgr().VFI.hBh();
      paramString.clear();
      paramMStorageEventData = paramMStorageEventData.iterator();
      while (paramMStorageEventData.hasNext()) {
        paramString.insert((EmojiGroupInfo)paramMStorageEventData.next(), paramString.getCount());
      }
      paramString.notifyDataSetChanged();
    }
    AppMethodBeat.o(108978);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(108979);
    Log.d("MicroMsg.emoji.EmojiSortUI", "ErrType:" + paramInt1 + "   errCode:" + paramInt2);
    if (this.mRa != null) {
      this.mRa.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt1 == 0))
    {
      this.uKo.cTP();
      finish();
      AppMethodBeat.o(108979);
      return;
    }
    com.tencent.mm.ui.base.h.d(this, getString(i.h.emoji_sort_failed), "", new DialogInterface.OnClickListener()
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