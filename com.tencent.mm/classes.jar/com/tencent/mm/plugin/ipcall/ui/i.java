package com.tencent.mm.plugin.ipcall.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMDotView;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i
  extends AlertDialog
  implements ViewPager.OnPageChangeListener
{
  private CharSequence Cv;
  private TextView Nx;
  private View iCk;
  private MMDotView jpZ;
  private Context mContext;
  private i.b nWm;
  private IPCallShareViewPager nWn;
  private View.OnClickListener nWo;
  private LinkedList<Integer> nWp;
  
  public final void dismiss()
  {
    AppMethodBeat.i(22356);
    try
    {
      super.dismiss();
      AppMethodBeat.o(22356);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.IPCallShareDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(22356);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22353);
    super.onCreate(paramBundle);
    getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
    getWindow().setGravity(80);
    getWindow().getDecorView().setPadding(0, 0, 0, 0);
    setContentView(this.iCk);
    AppMethodBeat.o(22353);
  }
  
  public final void onPageScrollStateChanged(int paramInt) {}
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(22354);
    if (this.nWm.getCount() <= 1)
    {
      this.jpZ.setVisibility(4);
      AppMethodBeat.o(22354);
      return;
    }
    this.jpZ.setVisibility(0);
    this.jpZ.setDotCount(this.nWm.getCount());
    this.jpZ.setSelectedDot(paramInt);
    AppMethodBeat.o(22354);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.Cv = paramCharSequence;
      return;
    }
    this.Cv = null;
  }
  
  public final void show()
  {
    AppMethodBeat.i(22355);
    if ((this.nWp == null) || (this.nWp.size() == 0))
    {
      AppMethodBeat.o(22355);
      return;
    }
    this.nWn.setOnPageChangeListener(this);
    i.b localb = new i.b(this);
    localb.nWq = this.nWo;
    localb.nWv = this.nWp;
    int i;
    if (localb.nWv.size() > 0)
    {
      localb.mCount = ((localb.nWv.size() - 1) / 9 + 1);
      i = 0;
    }
    for (;;)
    {
      if (i >= localb.mCount) {
        break label257;
      }
      View localView = ((LayoutInflater)localb.nWx.mContext.getSystemService("layout_inflater")).inflate(2130969948, null);
      GridView localGridView = (GridView)localView.findViewById(2131825326);
      ArrayList localArrayList = new ArrayList();
      int j = i * 9;
      for (;;)
      {
        if ((j < localb.nWv.size()) && (j < i * 9 + 9))
        {
          localArrayList.add(localb.nWv.get(j));
          j += 1;
          continue;
          localb.mCount = 0;
          break;
        }
      }
      i.a locala = new i.a(localb.nWx.getContext());
      locala.nWq = localb.nWq;
      locala.nxh = localArrayList;
      localGridView.setAdapter(locala);
      localb.nWw.add(localView);
      i += 1;
    }
    label257:
    this.nWm = localb;
    this.nWn.setAdapter(this.nWm);
    this.Nx.setText(this.Cv);
    super.show();
    AppMethodBeat.o(22355);
  }
  
  public final class a$a
  {
    int id;
    RelativeLayout nWs;
    TextView nWt;
    ImageView nWu;
    
    public a$a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.i
 * JD-Core Version:    0.7.0.1
 */