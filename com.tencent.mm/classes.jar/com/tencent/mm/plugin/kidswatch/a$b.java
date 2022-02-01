package com.tencent.mm.plugin.kidswatch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/ConstantsKidsWatch$ExtDeviceLoginRet;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "ExtDeviceLoginRet_Ok", "ExtDeviceLoginRet_Error", "ExtDeviceLoginRet_Expired", "ExtDeviceLoginRet_UnSupportDev", "ExtDeviceLoginRet_UnSupportApp", "ExtDeviceLoginRet_UnSupportClient_CanUpdate", "ExtDeviceLoginRet_UnSupportClient_NoUpdate", "ExtDeviceLoginRet_Error_NeedNotify", "ExtDeviceLoginRet_Error_AlbumBind", "ExtDeviceLoginRet_Sapm", "plugin-kidswatch_release"})
public enum a$b
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(256168);
    b localb1 = new b("ExtDeviceLoginRet_Ok", 0, 0);
    yAi = localb1;
    b localb2 = new b("ExtDeviceLoginRet_Error", 1, -1);
    yAj = localb2;
    b localb3 = new b("ExtDeviceLoginRet_Expired", 2, -2);
    yAk = localb3;
    b localb4 = new b("ExtDeviceLoginRet_UnSupportDev", 3, -3);
    yAl = localb4;
    b localb5 = new b("ExtDeviceLoginRet_UnSupportApp", 4, -4);
    yAm = localb5;
    b localb6 = new b("ExtDeviceLoginRet_UnSupportClient_CanUpdate", 5, -5);
    yAn = localb6;
    b localb7 = new b("ExtDeviceLoginRet_UnSupportClient_NoUpdate", 6, -6);
    yAo = localb7;
    b localb8 = new b("ExtDeviceLoginRet_Error_NeedNotify", 7, -7);
    yAp = localb8;
    b localb9 = new b("ExtDeviceLoginRet_Error_AlbumBind", 8, 8);
    yAq = localb9;
    b localb10 = new b("ExtDeviceLoginRet_Sapm", 9, -9);
    yAr = localb10;
    yAs = new b[] { localb1, localb2, localb3, localb4, localb5, localb6, localb7, localb8, localb9, localb10 };
    AppMethodBeat.o(256168);
  }
  
  private a$b(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.a.b
 * JD-Core Version:    0.7.0.1
 */