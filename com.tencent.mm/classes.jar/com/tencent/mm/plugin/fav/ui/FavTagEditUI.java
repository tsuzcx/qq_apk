package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.plugin.fav.ui.a.d;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.protocal.protobuf.add;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.q.b;
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
  private com.tencent.mm.plugin.fav.a.g mxX;
  private List<String> mxY;
  private FavTagPanel mxZ;
  private FavTagPanel mya;
  private ListView myb;
  private ListView myc;
  private TextView myd;
  private c mye;
  private d myf;
  private boolean myg;
  
  public static void a(com.tencent.mm.plugin.fav.a.g paramg, Collection<String> paramCollection, int paramInt)
  {
    AppMethodBeat.i(74158);
    if (paramg == null)
    {
      AppMethodBeat.o(74158);
      return;
    }
    ab.d("MicroMsg.FavTagEditUI", "mod tags %s", new Object[] { paramCollection });
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(paramg.field_tagProto.wVq);
    paramg.field_tagProto.wVq.clear();
    if ((paramCollection == null) || (paramCollection.isEmpty())) {}
    for (;;)
    {
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(paramg, new String[] { "localId" });
      b.p(paramg);
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavTagSetMgr().d(localHashSet);
      b.a(paramg, paramInt);
      AppMethodBeat.o(74158);
      return;
      paramg.field_tagProto.wVq.addAll(paramCollection);
      localHashSet.removeAll(paramCollection);
    }
  }
  
  private void bxE()
  {
    AppMethodBeat.i(74154);
    if (this.myg)
    {
      ab.w("MicroMsg.FavTagEditUI", "match max length, disable finish button");
      if (isOptionMenuEnable(0)) {
        enableOptionMenu(0, false);
      }
      AppMethodBeat.o(74154);
      return;
    }
    if (this.mxX == null)
    {
      if ((this.mya.getTagCount() <= 0) && (this.mya.getEditText().length() <= 0))
      {
        if (isOptionMenuEnable(0))
        {
          enableOptionMenu(0, false);
          AppMethodBeat.o(74154);
        }
      }
      else if (!isOptionMenuEnable(0))
      {
        enableOptionMenu(0, true);
        AppMethodBeat.o(74154);
      }
    }
    else if ((this.mxX.field_tagProto.wVq.size() != this.mya.getTagCount()) || (this.mya.getEditText().length() > 0))
    {
      if (!isOptionMenuEnable(0))
      {
        enableOptionMenu(0, true);
        AppMethodBeat.o(74154);
      }
    }
    else
    {
      ArrayList localArrayList = this.mya.getTagList();
      int i = 0;
      while (i < localArrayList.size())
      {
        if (!((String)localArrayList.get(i)).equals(this.mxX.field_tagProto.wVq.get(i)))
        {
          if (!isOptionMenuEnable(0)) {
            enableOptionMenu(0, true);
          }
          AppMethodBeat.o(74154);
          return;
        }
        i += 1;
      }
      if (isOptionMenuEnable(0)) {
        enableOptionMenu(0, false);
      }
    }
    AppMethodBeat.o(74154);
  }
  
  private void bxF()
  {
    AppMethodBeat.i(74157);
    h.d(getContext(), getString(2131299783), "", getString(2131296542), getString(2131296888), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(74140);
        FavTagEditUI.this.finish();
        AppMethodBeat.o(74140);
      }
    }, null);
    AppMethodBeat.o(74157);
  }
  
  public int getLayoutId()
  {
    return 2130969559;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74153);
    super.onCreate(paramBundle);
    long l = getIntent().getLongExtra("key_fav_item_id", -1L);
    if (-1L != l) {
      this.mxX = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(l);
    }
    this.mxY = getIntent().getStringArrayListExtra("key_fav_result_list");
    this.mya = ((FavTagPanel)findViewById(2131824082));
    this.myb = ((ListView)findViewById(2131824084));
    this.myc = ((ListView)findViewById(2131824089));
    this.myd = ((TextView)findViewById(2131824088));
    this.mya.qF(true);
    this.mya.setTagEditTextBG(2130840500);
    this.mya.setIsAllowEnterCharacter(true);
    this.mya.setCallBack(new FavTagEditUI.5(this));
    this.mya.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74146);
        FavTagEditUI.d(FavTagEditUI.this).dEn();
        FavTagEditUI.this.showVKB();
        AppMethodBeat.o(74146);
      }
    }, 100L);
    Object localObject;
    if (this.mxX != null)
    {
      this.mya.a(this.mxX.field_tagProto.wVq, this.mxX.field_tagProto.wVq);
      this.mye = new FavTagEditUI.7(this, getContext());
      localObject = this.mye;
      if (this.mxX != null) {
        break label631;
      }
    }
    label631:
    for (paramBundle = null;; paramBundle = this.mxX.field_tagProto.wVq)
    {
      ((c)localObject).bN(paramBundle);
      if ((this.mxX != null) && (!this.mxX.field_tagProto.wVp.isEmpty()))
      {
        paramBundle = View.inflate(getContext(), 2130969563, null);
        localObject = (TextView)paramBundle.findViewById(2131824094);
        ((TextView)localObject).setText(getString(2131299784));
        ((TextView)localObject).setVisibility(0);
        int i = getResources().getDimensionPixelSize(2131427660);
        this.mxZ = ((FavTagPanel)paramBundle.findViewById(2131824095));
        this.mxZ.setVisibility(0);
        this.mxZ.a(this.mxX.field_tagProto.wVq, this.mxX.field_tagProto.wVp);
        this.mxZ.setBackgroundResource(2130839285);
        this.mxZ.setPadding(0, 0, 0, i);
        this.mxZ.setCallBack(new FavTagEditUI.8(this));
        this.myb.addHeaderView(paramBundle);
      }
      if (((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavTagSetMgr().bww() > 0) {
        this.myb.addHeaderView(View.inflate(getContext(), 2130969562, null));
      }
      this.myb.setAdapter(this.mye);
      this.myb.setOnTouchListener(new FavTagEditUI.9(this));
      this.myf = new FavTagEditUI.10(this, getContext());
      this.myc.setAdapter(this.myf);
      this.myc.setOnTouchListener(new FavTagEditUI.2(this));
      setMMTitle(2131299703);
      setBackBtn(new FavTagEditUI.1(this));
      addTextOptionMenu(0, getString(2131296964), new FavTagEditUI.3(this, l), null, q.b.zby);
      bxE();
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavTagSetMgr().a(this.mye);
      AppMethodBeat.o(74153);
      return;
      if (this.mxY == null) {
        break;
      }
      this.mya.a(this.mxY, this.mxY);
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74155);
    super.onDestroy();
    l locall = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavTagSetMgr();
    c localc = this.mye;
    if (localc == null)
    {
      AppMethodBeat.o(74155);
      return;
    }
    locall.bat.remove(localc.toString());
    AppMethodBeat.o(74155);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(74156);
    if (paramInt == 4)
    {
      bxF();
      AppMethodBeat.o(74156);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(74156);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTagEditUI
 * JD-Core Version:    0.7.0.1
 */