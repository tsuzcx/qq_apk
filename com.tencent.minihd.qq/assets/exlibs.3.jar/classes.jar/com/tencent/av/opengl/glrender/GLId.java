package com.tencent.av.opengl.glrender;

import javax.microedition.khronos.opengles.GL11;
import javax.microedition.khronos.opengles.GL11ExtensionPack;

public abstract interface GLId
{
  public abstract int generateTexture();
  
  public abstract int[] generateTexture(int paramInt);
  
  public abstract void glDeleteBuffers(GL11 paramGL11, int paramInt1, int[] paramArrayOfInt, int paramInt2);
  
  public abstract void glDeleteFramebuffers(GL11ExtensionPack paramGL11ExtensionPack, int paramInt1, int[] paramArrayOfInt, int paramInt2);
  
  public abstract void glDeleteTextures(GL11 paramGL11, int paramInt1, int[] paramArrayOfInt, int paramInt2);
  
  public abstract void glGenBuffers(int paramInt1, int[] paramArrayOfInt, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.opengl.glrender.GLId
 * JD-Core Version:    0.7.0.1
 */