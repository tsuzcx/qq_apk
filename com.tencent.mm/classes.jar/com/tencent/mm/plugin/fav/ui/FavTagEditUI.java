package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.plugin.fav.ui.a.d;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.protocal.c.yw;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FavTagEditUI
  extends MMActivity
{
  private com.tencent.mm.plugin.fav.a.g kdn;
  private List<String> kdo;
  private FavTagPanel kdp;
  private FavTagPanel kdq;
  private ListView kdr;
  private ListView kds;
  private TextView kdt;
  private c kdu;
  private d kdv;
  private boolean kdw;
  
  public static void a(com.tencent.mm.plugin.fav.a.g paramg, Collection<String> paramCollection, int paramInt)
  {
    if (paramg == null) {
      return;
    }
    y.d("MicroMsg.FavTagEditUI", "mod tags %s", new Object[] { paramCollection });
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(paramg.field_tagProto.sXq);
    paramg.field_tagProto.sXq.clear();
    if ((paramCollection == null) || (paramCollection.isEmpty())) {}
    for (;;)
    {
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      b.p(paramg);
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavTagSetMgr().e(localHashSet);
      b.a(paramg, paramInt);
      return;
      paramg.field_tagProto.sXq.addAll(paramCollection);
      localHashSet.removeAll(paramCollection);
    }
  }
  
  private void aRp()
  {
    if (this.kdw)
    {
      y.w("MicroMsg.FavTagEditUI", "match max length, disable finish button");
      if (czl()) {
        enableOptionMenu(0, false);
      }
    }
    label86:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.kdn != null) {
              break label86;
            }
            if ((this.kdq.getTagCount() > 0) || (this.kdq.getEditText().length() > 0)) {
              break;
            }
          } while (!czl());
          enableOptionMenu(0, false);
          return;
        } while (czl());
        enableOptionMenu(0, true);
        return;
        if ((this.kdn.field_tagProto.sXq.size() == this.kdq.getTagCount()) && (this.kdq.getEditText().length() <= 0)) {
          break;
        }
      } while (czl());
      enableOptionMenu(0, true);
      return;
      ArrayList localArrayList = this.kdq.getTagList();
      int i = 0;
      for (;;)
      {
        if (i >= localArrayList.size()) {
          break label211;
        }
        if (!((String)localArrayList.get(i)).equals(this.kdn.field_tagProto.sXq.get(i)))
        {
          if (czl()) {
            break;
          }
          enableOptionMenu(0, true);
          return;
        }
        i += 1;
      }
    } while (!czl());
    label211:
    enableOptionMenu(0, false);
  }
  
  private void aRq()
  {
    h.a(this.mController.uMN, getString(n.i.favorite_quit_edit_tag_tips), "", getString(n.i.app_alert_exit), getString(n.i.app_cancel), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        FavTagEditUI.this.finish();
      }
    }, null);
  }
  
  protected final int getLayoutId()
  {
    return n.f.fav_tag_edit_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    long l = getIntent().getLongExtra("key_fav_item_id", -1L);
    if (-1L != l) {
      this.kdn = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(l);
    }
    this.kdo = getIntent().getStringArrayListExtra("key_fav_result_list");
    this.kdq = ((FavTagPanel)findViewById(n.e.fav_tag_input_panel));
    this.kdr = ((ListView)findViewById(n.e.tag_panel_list));
    this.kds = ((ListView)findViewById(n.e.search_tag_list));
    this.kdt = ((TextView)findViewById(n.e.max_size_tips_tv));
    this.kdq.nc(true);
    this.kdq.setTagEditTextBG(n.d.tag_edittext_gb);
    this.kdq.setIsAllowEnterCharacter(true);
    this.kdq.setCallBack(new FavTagEditUI.5(this));
    this.kdq.postDelayed(new Runnable()
    {
      public final void run()
      {
        FavTagEditUI.d(FavTagEditUI.this).cBa();
        FavTagEditUI.this.showVKB();
      }
    }, 100L);
    Object localObject;
    if (this.kdn != null)
    {
      this.kdq.a(this.kdn.field_tagProto.sXq, this.kdn.field_tagProto.sXq);
      this.kdu = new FavTagEditUI.7(this, this.mController.uMN);
      localObject = this.kdu;
      if (this.kdn != null) {
        break label632;
      }
    }
    label632:
    for (paramBundle = null;; paramBundle = this.kdn.field_tagProto.sXq)
    {
      ((c)localObject).bt(paramBundle);
      if ((this.kdn != null) && (!this.kdn.field_tagProto.sXp.isEmpty()))
      {
        paramBundle = View.inflate(this.mController.uMN, n.f.fav_tag_panel_item, null);
        localObject = (TextView)paramBundle.findViewById(n.e.fav_panel_catalog);
        ((TextView)localObject).setText(getString(n.i.favorite_recommended_tag));
        ((TextView)localObject).setVisibility(0);
        int i = getResources().getDimensionPixelSize(n.c.FavTagPadding);
        this.kdp = ((FavTagPanel)paramBundle.findViewById(n.e.fav_tag_panel));
        this.kdp.setVisibility(0);
        this.kdp.a(this.kdn.field_tagProto.sXq, this.kdn.field_tagProto.sXp);
        this.kdp.setBackgroundResource(n.d.list_thicklinecell_bg);
        this.kdp.setPadding(0, 0, 0, i);
        this.kdp.setCallBack(new FavTagEditUI.8(this));
        this.kdr.addHeaderView(paramBundle);
      }
      if (((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavTagSetMgr().aQh() > 0) {
        this.kdr.addHeaderView(View.inflate(this.mController.uMN, n.f.fav_tag_panel_headerview, null));
      }
      this.kdr.setAdapter(this.kdu);
      this.kdr.setOnTouchListener(new FavTagEditUI.9(this));
      this.kdv = new FavTagEditUI.10(this, this.mController.uMN);
      this.kds.setAdapter(this.kdv);
      this.kds.setOnTouchListener(new FavTagEditUI.2(this));
      setMMTitle(n.i.favorite_edit_tag_tips);
      setBackBtn(new FavTagEditUI.1(this));
      a(0, getString(n.i.app_finish), new FavTagEditUI.3(this, l), s.b.uNx);
      aRp();
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavTagSetMgr().a(this.kdu);
      return;
      if (this.kdo == null) {
        break;
      }
      this.kdq.a(this.kdo, this.kdo);
      break;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    l locall = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavTagSetMgr();
    c localc = this.kdu;
    if (localc == null) {
      return;
    }
    locall.elp.remove(localc.toString());
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      aRq();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTagEditUI
 * JD-Core Version:    0.7.0.1
 */