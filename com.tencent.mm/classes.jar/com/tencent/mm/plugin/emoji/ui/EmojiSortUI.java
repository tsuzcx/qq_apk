package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Message;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.a.e;
import com.tencent.mm.plugin.emoji.f.s;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.l;
import java.util.ArrayList;
import java.util.Iterator;

public class EmojiSortUI
  extends EmojiBaseActivity
  implements f, k.a
{
  ProgressDialog gsr;
  private e lmk;
  private DragSortListView lml;
  private s lmm;
  private DragSortListView.h lmn;
  private DragSortListView.l lmo;
  private ArrayList<EmojiGroupInfo> mData;
  
  public EmojiSortUI()
  {
    AppMethodBeat.i(53413);
    this.mData = new ArrayList();
    this.lmn = new EmojiSortUI.4(this);
    this.lmo = new EmojiSortUI.5(this);
    AppMethodBeat.o(53413);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(53417);
    if ((paramString != null) && (paramString.equals("event_update_group")) && (this.lmk != null))
    {
      paramString = this.lmk;
      paramm = i.getEmojiStorageMgr().yNo.dzh();
      paramString.clear();
      paramm = paramm.iterator();
      while (paramm.hasNext()) {
        paramString.insert((EmojiGroupInfo)paramm.next(), paramString.getCount());
      }
      paramString.notifyDataSetChanged();
    }
    AppMethodBeat.o(53417);
  }
  
  public int getLayoutId()
  {
    return 2130969379;
  }
  
  public void initView()
  {
    AppMethodBeat.i(53416);
    setBackBtn(new EmojiSortUI.1(this));
    setMMTitle(getString(2131303244));
    addTextOptionMenu(0, getString(2131296964), new EmojiSortUI.2(this));
    ((TextView)findViewById(16908310)).setText(2131299209);
    AppMethodBeat.o(53416);
  }
  
  public final void m(Message paramMessage) {}
  
  public final void n(Message paramMessage) {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(53414);
    super.onCreate(paramBundle);
    initView();
    this.mData = i.getEmojiStorageMgr().yNo.dzh();
    this.lml = ((DragSortListView)findViewById(16908298));
    this.lml.setDropListener(this.lmn);
    this.lml.setRemoveListener(this.lmo);
    this.lmk = new e(getContext(), this.mData);
    this.lml.setAdapter(this.lmk);
    i.getEmojiStorageMgr().yNo.add(this);
    g.RK().eHt.a(717, this);
    AppMethodBeat.o(53414);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(53415);
    i.getEmojiStorageMgr().yNo.remove(this);
    g.RK().eHt.b(717, this);
    super.onDestroy();
    AppMethodBeat.o(53415);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(53418);
    ab.d("MicroMsg.emoji.EmojiSortUI", "ErrType:" + paramInt1 + "   errCode:" + paramInt2);
    if (this.gsr != null) {
      this.gsr.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt1 == 0))
    {
      this.lmk.bkF();
      finish();
      AppMethodBeat.o(53418);
      return;
    }
    h.a(this, getString(2131299177), "", new EmojiSortUI.6(this));
    AppMethodBeat.o(53418);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiSortUI
 * JD-Core Version:    0.7.0.1
 */