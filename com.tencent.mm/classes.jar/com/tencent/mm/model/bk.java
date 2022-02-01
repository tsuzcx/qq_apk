package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.at;

public final class bk
{
  public static SharedPreferences bCE()
  {
    AppMethodBeat.i(132249);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("auth_info_key_prefs", g.aQe());
    if (!localSharedPreferences.getBoolean("key_auth_info_prefs_created", false))
    {
      f.Ozc.idkeyStat(148L, 12L, 1L, true);
      Object localObject = new ap(at.acHq + "autoauth.cfg");
      if ((!((ap)localObject).acGU) && (((ap)localObject).get(3) != null))
      {
        localEditor = localSharedPreferences.edit();
        localEditor.putBoolean("key_auth_info_prefs_created", true);
        localEditor.putInt("key_auth_update_version", ((Integer)((ap)localObject).get(1)).intValue());
        localEditor.putInt("_auth_uin", ((Integer)((ap)localObject).get(2)).intValue());
        localEditor.putString("_auth_key", (String)((ap)localObject).get(3));
        localEditor.putString("server_id", (String)((ap)localObject).get(4));
        Log.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! use autoauthcfg now commit[%b] create[%b], ver[%d], uin[%d], aak[%s], sid[%s]", new Object[] { Boolean.valueOf(localEditor.commit()), Boolean.valueOf(localSharedPreferences.getBoolean("key_auth_info_prefs_created", false)), Integer.valueOf(localSharedPreferences.getInt("key_auth_update_version", 0)), Integer.valueOf(localSharedPreferences.getInt("_auth_uin", 0)), localSharedPreferences.getString("_auth_key", ""), localSharedPreferences.getString("server_id", "") });
        f.Ozc.idkeyStat(148L, 51L, 1L, true);
        AppMethodBeat.o(132249);
        return localSharedPreferences;
      }
      localObject = MMApplicationContext.getContext().getSharedPreferences("auto_auth_key_prefs", g.aQe());
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      if (Util.isNullOrNil(((SharedPreferences)localObject).getString("_auth_key", ""))) {
        break label525;
      }
      localEditor.putBoolean("key_auth_info_prefs_created", true);
      localEditor.putInt("key_auth_update_version", ((SharedPreferences)localObject).getInt("key_auth_update_version", 0));
      localEditor.putInt("_auth_uin", ((SharedPreferences)localObject).getInt("_auth_uin", 0));
      localEditor.putString("_auth_key", ((SharedPreferences)localObject).getString("_auth_key", ""));
      localEditor.putString("server_id", MMApplicationContext.getContext().getSharedPreferences("server_id_prefs", g.aQe()).getString("server_id", ""));
      Log.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! use oldAAKsp now commit[%b] create[%b], ver[%d], uin[%d], aak[%s], sid[%s]", new Object[] { Boolean.valueOf(localEditor.commit()), Boolean.valueOf(localSharedPreferences.getBoolean("key_auth_info_prefs_created", false)), Integer.valueOf(localSharedPreferences.getInt("key_auth_update_version", 0)), Integer.valueOf(localSharedPreferences.getInt("_auth_uin", 0)), localSharedPreferences.getString("_auth_key", ""), localSharedPreferences.getString("server_id", "") });
    }
    for (;;)
    {
      AppMethodBeat.o(132249);
      return localSharedPreferences;
      label525:
      Log.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! neither autoauthcfg nor oldAAKsp existed just install! stack[%s]", new Object[] { Util.getStack() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bk
 * JD-Core Version:    0.7.0.1
 */