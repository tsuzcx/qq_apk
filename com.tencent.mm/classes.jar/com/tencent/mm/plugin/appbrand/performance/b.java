package com.tencent.mm.plugin.appbrand.performance;

import android.util.SparseArray;
import com.tencent.mm.plugin.appbrand.y.j;

public final class b
{
  public static final int[] gWp = new int[4];
  public static final SparseArray<Integer> gWq = new SparseArray();
  
  static
  {
    gWp[0] = y.j.appbrand_performance_basic;
    gWp[1] = y.j.appbrand_performance_init;
    gWp[2] = y.j.appbrand_performance_render;
    gWp[3] = y.j.appbrand_performance_other;
    gWq.put(101, Integer.valueOf(y.j.appbrand_performance_cpu));
    gWq.put(102, Integer.valueOf(y.j.appbrand_performance_memory));
    gWq.put(103, Integer.valueOf(y.j.appbrand_performance_memory_delta));
    gWq.put(201, Integer.valueOf(y.j.appbrand_performance_download));
    gWq.put(202, Integer.valueOf(y.j.appbrand_performance_launching));
    gWq.put(203, Integer.valueOf(y.j.appbrand_performance_switch));
    gWq.put(301, Integer.valueOf(y.j.appbrand_performance_first_render));
    gWq.put(302, Integer.valueOf(y.j.appbrand_performance_re_render));
    gWq.put(303, Integer.valueOf(y.j.appbrand_performance_fps));
    gWq.put(401, Integer.valueOf(y.j.appbrand_performance_storage));
    gWq.put(402, Integer.valueOf(y.j.appbrand_performance_to_logic));
    gWq.put(403, Integer.valueOf(y.j.appbrand_performance_to_logic_data));
    gWq.put(404, Integer.valueOf(y.j.appbrand_performance_to_logic_native));
    gWq.put(405, Integer.valueOf(y.j.appbrand_performance_to_view));
    gWq.put(406, Integer.valueOf(y.j.appbrand_performance_to_view_data));
    gWq.put(407, Integer.valueOf(y.j.appbrand_performance_to_view_native));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.b
 * JD-Core Version:    0.7.0.1
 */