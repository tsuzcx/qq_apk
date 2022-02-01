package com.tencent.mm.plugin.ball.f;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.ball.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bf;

public final class e
{
  public static final int vmb;
  public static final int vmc;
  public static final int vmd;
  public static final int vme;
  public static final int vmf;
  public static final int vmg;
  public static final int vmh;
  public static final int vmi;
  public static final float vmj;
  public static final int vmk;
  public static final int vml;
  public static final int vmm;
  public static int vmn;
  public static final int vmo;
  public static final int vmp;
  
  static
  {
    AppMethodBeat.i(106369);
    vmb = bf.getStatusBarHeight(MMApplicationContext.getContext());
    vmc = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_ball_outer_margin);
    vmd = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_ball_size);
    vme = a.bs(MMApplicationContext.getContext(), a.c.float_ball_shadow_top);
    vmf = a.bs(MMApplicationContext.getContext(), a.c.float_ball_shadow_bottom);
    vmg = a.bs(MMApplicationContext.getContext(), a.c.float_ball_shadow_horizontal);
    vmh = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_corner_view_size);
    int i = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_corner_view_scale_size);
    vmi = i;
    vmj = i / vmh;
    vmk = a.ms(MMApplicationContext.getContext()) - (vmd + vmg);
    vml = vmc + vmb;
    vmm = a.mt(MMApplicationContext.getContext()) - vmc - (vmd + vme + vmf);
    vmn = bk(MMApplicationContext.getContext());
    vmo = vml;
    vmp = (int)(a.mt(MMApplicationContext.getContext()) * 0.3F);
    AppMethodBeat.o(106369);
  }
  
  private static int bk(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(106367);
    try
    {
      int j = bf.bk(paramContext);
      i = j;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.e("MicroMsg.FloatBallViewConstants", "getNavigationBarHeight exception:%s", new Object[] { paramContext });
      }
    }
    AppMethodBeat.o(106367);
    return i;
  }
  
  public static void fE(Context paramContext)
  {
    AppMethodBeat.i(106368);
    vmn = bk(paramContext);
    AppMethodBeat.o(106368);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(106366);
      vmq = new a("TOP_LEFT", 0);
      vmr = new a("TOP_RIGHT", 1);
      vms = new a("BOTTOM_LEFT", 2);
      vmt = new a("BOTTOM_RIGHT", 3);
      vmu = new a[] { vmq, vmr, vms, vmt };
      AppMethodBeat.o(106366);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.e
 * JD-Core Version:    0.7.0.1
 */