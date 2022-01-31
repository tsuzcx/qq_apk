package com.tencent.mm.modelsimple;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.bk;

public final class q$a
{
  public String bJY;
  public String bQZ;
  public String ezP;
  public Bundle ezQ;
  public int type;
  public String username;
  
  public final String toString()
  {
    return String.format("AuthBioInfo hash[%d], type[%d]. username[%s], ticket[%s], helpUrlp[%s], wording[%s], extra[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.type), this.username, bk.aac(this.bJY), this.ezP, this.bQZ, this.ezQ });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelsimple.q.a
 * JD-Core Version:    0.7.0.1
 */