package com.tencent.mm.plugin.ipcall.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager.e;
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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMDotView;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i
  extends AlertDialog
  implements ViewPager.e
{
  private CharSequence BM;
  private TextView NI;
  private MMDotView hxP;
  private View ipf;
  private i.b lza;
  private IPCallShareViewPager lzb;
  private View.OnClickListener lzc;
  private LinkedList<Integer> lzd;
  private Context mContext;
  
  public final void Q(int paramInt) {}
  
  public final void R(int paramInt)
  {
    if (this.lza.getCount() <= 1)
    {
      this.hxP.setVisibility(4);
      return;
    }
    this.hxP.setVisibility(0);
    this.hxP.setDotCount(this.lza.getCount());
    this.hxP.setSelectedDot(paramInt);
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.IPCallShareDialog", "dismiss exception, e = " + localException.getMessage());
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
    getWindow().setGravity(80);
    getWindow().getDecorView().setPadding(0, 0, 0, 0);
    setContentView(this.ipf);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.BM = paramCharSequence;
      return;
    }
    this.BM = null;
  }
  
  public final void show()
  {
    if ((this.lzd == null) || (this.lzd.size() == 0)) {
      return;
    }
    this.lzb.setOnPageChangeListener(this);
    i.b localb = new i.b(this);
    localb.lze = this.lzc;
    localb.lzj = this.lzd;
    int i;
    if (localb.lzj.size() > 0)
    {
      localb.mCount = ((localb.lzj.size() - 1) / 9 + 1);
      i = 0;
    }
    for (;;)
    {
      if (i >= localb.mCount) {
        break label247;
      }
      View localView = ((LayoutInflater)localb.lzl.mContext.getSystemService("layout_inflater")).inflate(R.i.ipcall_share_grid_view, null);
      GridView localGridView = (GridView)localView.findViewById(R.h.ipcall_share_list);
      ArrayList localArrayList = new ArrayList();
      int j = i * 9;
      for (;;)
      {
        if ((j < localb.lzj.size()) && (j < i * 9 + 9))
        {
          localArrayList.add(localb.lzj.get(j));
          j += 1;
          continue;
          localb.mCount = 0;
          break;
        }
      }
      i.a locala = new i.a(localb.lzl.getContext());
      locala.lze = localb.lze;
      locala.kZk = localArrayList;
      localGridView.setAdapter(locala);
      localb.lzk.add(localView);
      i += 1;
    }
    label247:
    this.lza = localb;
    this.lzb.setAdapter(this.lza);
    this.NI.setText(this.BM);
    super.show();
  }
  
  public final class a$a
  {
    int id;
    RelativeLayout lzg;
    TextView lzh;
    ImageView lzi;
    
    public a$a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.i
 * JD-Core Version:    0.7.0.1
 */