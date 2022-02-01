package com.tencent.mm.plugin.appbrand.performance;

import android.util.SparseArray;
import com.tencent.luggage.n.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public static final int[] tDN;
  public static final SparseArray<Integer> tDO;
  
  static
  {
    AppMethodBeat.i(139904);
    tDN = new int[4];
    tDO = new SparseArray();
    tDN[0] = b.c.app_brand_performance_basic;
    tDN[1] = b.c.app_brand_performance_init;
    tDN[2] = b.c.app_brand_performance_render;
    tDN[3] = b.c.app_brand_performance_other;
    tDO.put(101, Integer.valueOf(b.c.app_brand_performance_cpu));
    tDO.put(102, Integer.valueOf(b.c.app_brand_performance_memory));
    tDO.put(103, Integer.valueOf(b.c.app_brand_performance_memory_delta));
    tDO.put(104, Integer.valueOf(b.c.app_brand_performance_memory_native));
    tDO.put(105, Integer.valueOf(b.c.app_brand_performance_memory_details));
    tDO.put(201, Integer.valueOf(b.c.app_brand_performance_download));
    tDO.put(202, Integer.valueOf(b.c.app_brand_performance_launching));
    tDO.put(203, Integer.valueOf(b.c.app_brand_performance_switch));
    tDO.put(301, Integer.valueOf(b.c.app_brand_performance_first_render));
    tDO.put(302, Integer.valueOf(b.c.app_brand_performance_re_render));
    tDO.put(204, Integer.valueOf(b.c.app_brand_performance_jsinject));
    tDO.put(205, Integer.valueOf(b.c.app_brand_performance_js2render));
    tDO.put(303, Integer.valueOf(b.c.app_brand_performance_fps));
    tDO.put(401, Integer.valueOf(b.c.app_brand_performance_storage));
    tDO.put(402, Integer.valueOf(b.c.app_brand_performance_to_logic));
    tDO.put(403, Integer.valueOf(b.c.app_brand_performance_to_logic_data));
    tDO.put(404, Integer.valueOf(b.c.app_brand_performance_to_logic_native));
    tDO.put(405, Integer.valueOf(b.c.app_brand_performance_to_view));
    tDO.put(406, Integer.valueOf(b.c.app_brand_performance_to_view_data));
    tDO.put(407, Integer.valueOf(b.c.app_brand_performance_to_view_native));
    AppMethodBeat.o(139904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.d
 * JD-Core Version:    0.7.0.1
 */