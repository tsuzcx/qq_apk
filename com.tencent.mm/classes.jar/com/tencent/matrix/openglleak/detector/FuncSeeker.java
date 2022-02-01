package com.tencent.matrix.openglleak.detector;

class FuncSeeker
{
  public static int gR(String paramString)
  {
    if (paramString.equals("glGetError")) {
      return getGlGetErrorIndex();
    }
    if ((paramString.startsWith("glGen")) || (paramString.startsWith("glDelete"))) {
      return getTargetFuncIndex(paramString);
    }
    if (paramString.startsWith("glBind")) {
      return getBindFuncIndex(paramString);
    }
    if (paramString.equals("glTexImage2D")) {
      return getGlTexImage2DIndex();
    }
    if (paramString.equals("glTexImage3D")) {
      return getGlTexImage3DIndex();
    }
    if (paramString.equals("glBufferData")) {
      return getGlBufferDataIndex();
    }
    if (paramString.equals("glRenderbufferStorage")) {
      return getGlRenderbufferStorageIndex();
    }
    return 0;
  }
  
  private static native int getBindFuncIndex(String paramString);
  
  private static native int getGlBufferDataIndex();
  
  private static native int getGlGetErrorIndex();
  
  private static native int getGlRenderbufferStorageIndex();
  
  private static native int getGlTexImage2DIndex();
  
  private static native int getGlTexImage3DIndex();
  
  private static native int getTargetFuncIndex(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.openglleak.detector.FuncSeeker
 * JD-Core Version:    0.7.0.1
 */