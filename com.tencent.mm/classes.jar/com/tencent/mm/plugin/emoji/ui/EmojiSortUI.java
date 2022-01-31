package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.a.e;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.f.t;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.l;
import java.util.ArrayList;
import java.util.Iterator;

public class EmojiSortUI
  extends EmojiBaseActivity
  implements f, j.a
{
  ProgressDialog faz;
  private DragSortListView.h jdA = new EmojiSortUI.4(this);
  private DragSortListView.l jdB = new EmojiSortUI.5(this);
  private e jdx;
  private DragSortListView jdy;
  private t jdz;
  private ArrayList<EmojiGroupInfo> mData = new ArrayList();
  
  public final void a(String paramString, l paraml)
  {
    if ((paramString != null) && (paramString.equals("event_update_group")) && (this.jdx != null))
    {
      paramString = this.jdx;
      paraml = i.getEmojiStorageMgr().uBc.cww();
      paramString.clear();
      paraml = paraml.iterator();
      while (paraml.hasNext()) {
        paramString.insert((EmojiGroupInfo)paraml.next(), paramString.getCount());
      }
      paramString.notifyDataSetChanged();
    }
  }
  
  protected final int getLayoutId()
  {
    return f.f.emoji_sort;
  }
  
  public final void h(Message paramMessage) {}
  
  public final void i(Message paramMessage) {}
  
  protected final void initView()
  {
    setBackBtn(new EmojiSortUI.1(this));
    setMMTitle(getString(f.h.settings_emoji_manager));
    addTextOptionMenu(0, getString(f.h.app_finish), new EmojiSortUI.2(this));
    ((TextView)findViewById(16908310)).setText(f.h.emoji_store_manage_title);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    this.mData = i.getEmojiStorageMgr().uBc.cww();
    this.jdy = ((DragSortListView)findViewById(16908298));
    this.jdy.setDropListener(this.jdA);
    this.jdy.setRemoveListener(this.jdB);
    this.jdx = new e(this.mController.uMN, this.mData);
    this.jdy.setAdapter(this.jdx);
    i.getEmojiStorageMgr().uBc.c(this);
    g.DO().dJT.a(717, this);
  }
  
  protected void onDestroy()
  {
    i.getEmojiStorageMgr().uBc.d(this);
    g.DO().dJT.b(717, this);
    super.onDestroy();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.emoji.EmojiSortUI", "ErrType:" + paramInt1 + "   errCode:" + paramInt2);
    if (this.faz != null) {
      this.faz.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt1 == 0))
    {
      this.jdx.aGT();
      finish();
      return;
    }
    h.a(this, getString(f.h.emoji_sort_failed), "", new EmojiSortUI.6(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiSortUI
 * JD-Core Version:    0.7.0.1
 */