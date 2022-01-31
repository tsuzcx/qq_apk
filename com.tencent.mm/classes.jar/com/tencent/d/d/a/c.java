package com.tencent.d.d.a;

import android.text.TextUtils;
import com.tencent.d.d.b.d.a;
import com.tencent.d.f.h;
import java.util.ArrayList;
import java.util.List;

public final class c
  implements b
{
  private final List<d.a> wMM = new ArrayList();
  
  public final void a(d.a parama)
  {
    if (parama.uid != 0) {}
    while ((TextUtils.isEmpty(parama.wMU)) || (!"u:r:zygote:s0".equals(parama.wMU)) || (TextUtils.isEmpty(parama.name)) || ("zygote".equals(parama.name)) || ("zygote64".equals(parama.name))) {
      return;
    }
    h.i("JavaProcessAnalyzer match : " + parama.toString());
    this.wMM.add(parama);
  }
  
  public final boolean cOI()
  {
    return this.wMM.size() > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.d.d.a.c
 * JD-Core Version:    0.7.0.1
 */