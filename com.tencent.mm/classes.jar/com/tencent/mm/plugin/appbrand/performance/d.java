package com.tencent.mm.plugin.appbrand.performance;

import android.util.SparseArray;
import com.tencent.luggage.m.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public static final int[] qyS;
  public static final SparseArray<Integer> qyT;
  
  static
  {
    AppMethodBeat.i(139904);
    qyS = new int[4];
    qyT = new SparseArray();
    qyS[0] = b.c.app_brand_performance_basic;
    qyS[1] = b.c.app_brand_performance_init;
    qyS[2] = b.c.app_brand_performance_render;
    qyS[3] = b.c.app_brand_performance_other;
    qyT.put(101, Integer.valueOf(b.c.app_brand_performance_cpu));
    qyT.put(102, Integer.valueOf(b.c.app_brand_performance_memory));
    qyT.put(103, Integer.valueOf(b.c.app_brand_performance_memory_delta));
    qyT.put(104, Integer.valueOf(b.c.app_brand_performance_memory_native));
    qyT.put(105, Integer.valueOf(b.c.app_brand_performance_memory_details));
    qyT.put(201, Integer.valueOf(b.c.app_brand_performance_download));
    qyT.put(202, Integer.valueOf(b.c.app_brand_performance_launching));
    qyT.put(203, Integer.valueOf(b.c.app_brand_performance_switch));
    qyT.put(301, Integer.valueOf(b.c.app_brand_performance_first_render));
    qyT.put(302, Integer.valueOf(b.c.app_brand_performance_re_render));
    qyT.put(204, Integer.valueOf(b.c.app_brand_performance_jsinject));
    qyT.put(205, Integer.valueOf(b.c.app_brand_performance_js2render));
    qyT.put(303, Integer.valueOf(b.c.app_brand_performance_fps));
    qyT.put(401, Integer.valueOf(b.c.app_brand_performance_storage));
    qyT.put(402, Integer.valueOf(b.c.app_brand_performance_to_logic));
    qyT.put(403, Integer.valueOf(b.c.app_brand_performance_to_logic_data));
    qyT.put(404, Integer.valueOf(b.c.app_brand_performance_to_logic_native));
    qyT.put(405, Integer.valueOf(b.c.app_brand_performance_to_view));
    qyT.put(406, Integer.valueOf(b.c.app_brand_performance_to_view_data));
    qyT.put(407, Integer.valueOf(b.c.app_brand_performance_to_view_native));
    AppMethodBeat.o(139904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.d
 * JD-Core Version:    0.7.0.1
 */