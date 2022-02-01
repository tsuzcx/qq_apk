package com.tencent.mm.plugin.kidswatch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/kidswatch/ConstantsKidsWatch$ExtDeviceLoginRet;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "ExtDeviceLoginRet_Ok", "ExtDeviceLoginRet_Error", "ExtDeviceLoginRet_Expired", "ExtDeviceLoginRet_UnSupportDev", "ExtDeviceLoginRet_UnSupportApp", "ExtDeviceLoginRet_UnSupportClient_CanUpdate", "ExtDeviceLoginRet_UnSupportClient_NoUpdate", "ExtDeviceLoginRet_Error_NeedNotify", "ExtDeviceLoginRet_Error_AlbumBind", "ExtDeviceLoginRet_Sapm", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a$b
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(262089);
    JRi = new b("ExtDeviceLoginRet_Ok", 0, 0);
    JRj = new b("ExtDeviceLoginRet_Error", 1, -1);
    JRk = new b("ExtDeviceLoginRet_Expired", 2, -2);
    JRl = new b("ExtDeviceLoginRet_UnSupportDev", 3, -3);
    JRm = new b("ExtDeviceLoginRet_UnSupportApp", 4, -4);
    JRn = new b("ExtDeviceLoginRet_UnSupportClient_CanUpdate", 5, -5);
    JRo = new b("ExtDeviceLoginRet_UnSupportClient_NoUpdate", 6, -6);
    JRp = new b("ExtDeviceLoginRet_Error_NeedNotify", 7, -7);
    JRq = new b("ExtDeviceLoginRet_Error_AlbumBind", 8, 8);
    JRr = new b("ExtDeviceLoginRet_Sapm", 9, -9);
    JRs = new b[] { JRi, JRj, JRk, JRl, JRm, JRn, JRo, JRp, JRq, JRr };
    AppMethodBeat.o(262089);
  }
  
  private a$b(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.a.b
 * JD-Core Version:    0.7.0.1
 */