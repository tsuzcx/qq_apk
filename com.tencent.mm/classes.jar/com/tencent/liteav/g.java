package com.tencent.liteav;

import android.graphics.Bitmap;
import com.tencent.liteav.basic.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;

public class g
  implements Cloneable
{
  public boolean A = false;
  public Bitmap B = null;
  public int C = 300;
  public int D = 10;
  public int E = 1;
  public Bitmap F = null;
  public int G = 0;
  public int H = 0;
  public float I = 0.0F;
  public float J = 0.0F;
  public float K = -1.0F;
  public boolean L = true;
  public boolean M = false;
  public boolean N = false;
  public boolean O = true;
  public int P = 1;
  public boolean Q = false;
  public boolean R = false;
  public int S = 0;
  public boolean T = false;
  public boolean U = true;
  public boolean V = false;
  public boolean W = false;
  public boolean X = false;
  public int Y = 0;
  public JSONArray Z = null;
  public int a = 0;
  public int b = 0;
  public int c = 1200;
  public int d = 1500;
  public int e = 800;
  public int f = 5;
  public boolean g = true;
  public boolean h = false;
  public int i = 20;
  public int j = 1;
  public int k = 2;
  public c l = c.c;
  public int m = 1;
  public boolean n = true;
  public int o = 3;
  public int p = 0;
  public boolean q = false;
  public int r = 3;
  public int s = 3;
  public int t = 48000;
  public int u = 1;
  public boolean v = true;
  public boolean w = false;
  public boolean x = false;
  public int y = 0;
  public int z = 10;
  
  public static a a(c paramc)
  {
    AppMethodBeat.i(244835);
    a locala = new a();
    switch (1.a[paramc.ordinal()])
    {
    default: 
      locala.a = 368;
      locala.b = 640;
    }
    for (;;)
    {
      AppMethodBeat.o(244835);
      return locala;
      locala.a = 368;
      locala.b = 640;
      continue;
      locala.a = 544;
      locala.b = 960;
      continue;
      locala.a = 720;
      locala.b = 1280;
      continue;
      locala.a = 320;
      locala.b = 480;
      continue;
      locala.a = 192;
      locala.b = 320;
      continue;
      locala.a = 272;
      locala.b = 480;
      continue;
      locala.a = 240;
      locala.b = 320;
      continue;
      locala.a = 368;
      locala.b = 480;
      continue;
      locala.a = 480;
      locala.b = 640;
      continue;
      locala.a = 480;
      locala.b = 480;
      continue;
      locala.a = 272;
      locala.b = 272;
      continue;
      locala.a = 160;
      locala.b = 160;
      continue;
      locala.a = 640;
      locala.b = 368;
      continue;
      locala.a = 960;
      locala.b = 544;
      continue;
      locala.a = 1280;
      locala.b = 720;
      continue;
      locala.a = 640;
      locala.b = 480;
      continue;
      locala.a = 480;
      locala.b = 368;
      continue;
      locala.a = 320;
      locala.b = 240;
      continue;
      locala.a = 480;
      locala.b = 272;
      continue;
      locala.a = 320;
      locala.b = 192;
      continue;
      locala.a = 128;
      locala.b = 128;
      continue;
      locala.a = 1088;
      locala.b = 1920;
      continue;
      locala.a = 1920;
      locala.b = 1088;
    }
  }
  
  public boolean a()
  {
    AppMethodBeat.i(244836);
    if (this.l != c.a)
    {
      a locala = a(this.l);
      this.a = locala.a;
      this.b = locala.b;
    }
    if (this.a > this.b)
    {
      AppMethodBeat.o(244836);
      return true;
    }
    AppMethodBeat.o(244836);
    return false;
  }
  
  protected Object clone()
  {
    AppMethodBeat.i(244837);
    g localg = (g)super.clone();
    AppMethodBeat.o(244837);
    return localg;
  }
  
  public static class a
  {
    public int a = 0;
    public int b = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.g
 * JD-Core Version:    0.7.0.1
 */