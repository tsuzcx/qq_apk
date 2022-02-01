package com.tencent.magicbrush.vulkan;

import com.tencent.magicbrush.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VulkanJniExport
{
  static
  {
    AppMethodBeat.i(140076);
    b.loadLibrary("mmvulkan");
    AppMethodBeat.o(140076);
  }
  
  public static native boolean isSupportVulkan();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.vulkan.VulkanJniExport
 * JD-Core Version:    0.7.0.1
 */