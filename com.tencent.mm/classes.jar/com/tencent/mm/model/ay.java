package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.y;

public final class ay
{
  public static SharedPreferences aaF()
  {
    AppMethodBeat.i(58105);
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("auth_info_key_prefs", h.Mp());
    if (!localSharedPreferences.getBoolean("key_auth_info_prefs_created", false))
    {
      e.qrI.idkeyStat(148L, 12L, 1L, true);
      Object localObject = new y(ac.eQv + "autoauth.cfg");
      if ((!((y)localObject).yxb) && (((y)localObject).get(3) != null))
      {
        localEditor = localSharedPreferences.edit();
        localEditor.putBoolean("key_auth_info_prefs_created", true);
        localEditor.putInt("key_auth_update_version", ((Integer)((y)localObject).get(1)).intValue());
        localEditor.putInt("_auth_uin", ((Integer)((y)localObject).get(2)).intValue());
        localEditor.putString("_auth_key", (String)((y)localObject).get(3));
        localEditor.putString("server_id", (String)((y)localObject).get(4));
        ab.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! use autoauthcfg now commit[%b] create[%b], ver[%d], uin[%d], aak[%s], sid[%s]", new Object[] { Boolean.valueOf(localEditor.commit()), Boolean.valueOf(localSharedPreferences.getBoolean("key_auth_info_prefs_created", false)), Integer.valueOf(localSharedPreferences.getInt("key_auth_update_version", 0)), Integer.valueOf(localSharedPreferences.getInt("_auth_uin", 0)), localSharedPreferences.getString("_auth_key", ""), localSharedPreferences.getString("server_id", "") });
        e.qrI.idkeyStat(148L, 51L, 1L, true);
        AppMethodBeat.o(58105);
        return localSharedPreferences;
      }
      localObject = ah.getContext().getSharedPreferences("auto_auth_key_prefs", h.Mp());
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      if (bo.isNullOrNil(((SharedPreferences)localObject).getString("_auth_key", ""))) {
        break label525;
      }
      localEditor.putBoolean("key_auth_info_prefs_created", true);
      localEditor.putInt("key_auth_update_version", ((SharedPreferences)localObject).getInt("key_auth_update_version", 0));
      localEditor.putInt("_auth_uin", ((SharedPreferences)localObject).getInt("_auth_uin", 0));
      localEditor.putString("_auth_key", ((SharedPreferences)localObject).getString("_auth_key", ""));
      localEditor.putString("server_id", ah.getContext().getSharedPreferences("server_id_prefs", h.Mp()).getString("server_id", ""));
      ab.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! use oldAAKsp now commit[%b] create[%b], ver[%d], uin[%d], aak[%s], sid[%s]", new Object[] { Boolean.valueOf(localEditor.commit()), Boolean.valueOf(localSharedPreferences.getBoolean("key_auth_info_prefs_created", false)), Integer.valueOf(localSharedPreferences.getInt("key_auth_update_version", 0)), Integer.valueOf(localSharedPreferences.getInt("_auth_uin", 0)), localSharedPreferences.getString("_auth_key", ""), localSharedPreferences.getString("server_id", "") });
    }
    for (;;)
    {
      AppMethodBeat.o(58105);
      return localSharedPreferences;
      label525:
      ab.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! neither autoauthcfg nor oldAAKsp existed just install! stack[%s]", new Object[] { bo.dtY() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.ay
 * JD-Core Version:    0.7.0.1
 */