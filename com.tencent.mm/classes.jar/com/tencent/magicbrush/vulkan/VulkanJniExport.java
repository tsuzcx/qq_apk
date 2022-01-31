package com.tencent.magicbrush.vulkan;

import com.tencent.magicbrush.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VulkanJniExport
{
  static
  {
    AppMethodBeat.i(116016);
    b.loadLibrary("mmvulkan");
    AppMethodBeat.o(116016);
  }
  
  public static native boolean isSupportVulkan();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.vulkan.VulkanJniExport
 * JD-Core Version:    0.7.0.1
 */