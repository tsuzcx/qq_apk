package com.tencent.mm.compatible.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

final class s
{
  public static boolean a(String paramString, o paramo, c paramc, b paramb, k paramk, y paramy, ae paramae, t paramt, x paramx, ab paramab, w paramw1, a parama, w paramw2)
  {
    AppMethodBeat.i(92991);
    try
    {
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.DeviceInfoParser", "xml: ".concat(String.valueOf(paramString)));
      Map localMap = br.F(paramString, "deviceinfoconfig");
      if (localMap == null)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeviceInfoParser", "hy: null device config");
        AppMethodBeat.o(92991);
        return false;
      }
      if (localMap.get(".deviceinfoconfig.voip.cpu.armv7") != null)
      {
        paramo.epQ = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.cpu.armv7"), 0);
        paramo.epP = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.cpu.armv6") != null)
      {
        paramo.epR = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.cpu.armv6"), 0);
        paramo.epP = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.num") != null)
      {
        paramc.enO = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.num"), 0);
        paramc.enP = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.surface") != null)
      {
        paramc.enQ = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.surface"), 0);
        paramc.enR = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.format") != null)
      {
        paramc.enU = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.format"), 0);
        paramc.aBO = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.autofloat") != null) {
        paramc.enS = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.autofloat"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.manufloat") != null) {
        paramc.enT = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.manufloat"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.enable") != null)
      {
        paramc.enX.eoD = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.enable"), 0);
        paramc.enY = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.fps") != null)
      {
        paramc.enX.fps = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.fps"), 0);
        paramc.enY = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.orien") != null)
      {
        paramc.enX.eoE = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.orien"), 0);
        paramc.enY = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.rotate") != null)
      {
        paramc.enX.rotate = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.rotate"), 0);
        paramc.enY = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.isleft") != null)
      {
        paramc.enX.eoF = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.isleft"), 0);
        paramc.enY = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.width") != null)
      {
        paramc.enX.width = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.width"), 0);
        paramc.enY = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.height") != null)
      {
        paramc.enX.height = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.height"), 0);
        paramc.enY = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.enable") != null)
      {
        paramc.enV.eoD = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.enable"), 0);
        paramc.enW = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.fps") != null)
      {
        paramc.enV.fps = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.fps"), 0);
        paramc.enW = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.orien") != null)
      {
        paramc.enV.eoE = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.orien"), 0);
        paramc.enW = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.rotate") != null)
      {
        paramc.enV.rotate = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.rotate"), 0);
        paramc.enW = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.isleft") != null)
      {
        paramc.enV.eoF = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.isleft"), 0);
        paramc.enW = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.width") != null)
      {
        paramc.enV.width = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.width"), 0);
        paramc.enW = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.height") != null)
      {
        paramc.enV.height = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.height"), 0);
        paramc.enW = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.frotate") != null)
      {
        paramc.eoa = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.frotate"), 0);
        paramc.enZ = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.forientation") != null)
      {
        paramc.eob = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.forientation"), 0);
        paramc.enZ = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.brotate") != null)
      {
        paramc.eoc = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.brotate"), 0);
        paramc.enZ = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.borientation") != null)
      {
        paramc.eod = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.borientation"), 0);
        paramc.enZ = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.num") != null)
      {
        paramc.eoe = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
        paramc.eog = true;
        paramc.enZ = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
        paramc.eoi = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
        paramc.eoh = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold") != null) {
        paramc.eoj = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.scannerImageQuality") != null) {
        paramc.eok = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.scannerImageQuality"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval") != null) {
        paramc.eow = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.focusType") != null) {
        paramc.eox = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.focusType"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.num") != null)
      {
        paramc.eoe = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
        paramc.eog = true;
        paramc.enZ = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
        paramc.eoi = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
        paramc.eoh = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.useFixFPSMode") != null) {
        paramc.eol = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.useFixFPSMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.useRangeFPSMode") != null) {
        paramc.eom = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.useRangeFPSMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat") != null) {
        paramc.eon = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.useMeteringMode") != null) {
        paramc.eoo = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.useMeteringMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode") != null) {
        paramc.eop = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported") != null) {
        paramc.eoq = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.sightCameraID") != null) {
        paramc.eos = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.sightCameraID"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.needEnhance") != null) {
        paramc.eot = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.needEnhance"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.support480enc") != null) {
        paramc.eou = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.support480enc"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.supportHWenc") != null) {
        paramc.eov = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.supportHWenc"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.voipBeauty") != null) {
        paramc.eoy = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.voipBeauty"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.voipBeautyWhite") != null) {
        paramc.eoz = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.voipBeautyWhite"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.fpsMin") != null) {
        paramc.eoA = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.fpsMin"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.fpsMax") != null) {
        paramc.eoB = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.fpsMax"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.autoRotate") != null) {
        paramc.eoC = bo.getBoolean((String)localMap.get(".deviceinfoconfig.voip.camera.autoRotate"), false);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.streamtype") != null)
      {
        paramb.emE = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.streamtype"), 0);
        paramb.emD = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.smode") != null)
      {
        paramb.emF = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.smode"), 0);
        paramb.emD = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.omode") != null)
      {
        paramb.emG = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.omode"), 0);
        paramb.emD = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ospeaker") != null)
      {
        paramb.emH = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ospeaker"), 0);
        paramb.emD = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.operating") != null)
      {
        paramb.emI = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.operating"), 0);
        paramb.emD = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.moperating") != null)
      {
        paramb.emJ = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.moperating"), 0);
        paramb.emD = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mstreamtype") != null)
      {
        paramb.emK = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mstreamtype"), 0);
        paramb.emD = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.recordmode") != null) {
        paramb.emL = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.recordmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
        paramb.emM = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.aecmode") != null) {
        paramb.emN = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.aecmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.nsmode") != null) {
        paramb.emO = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.nsmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.volummode") != null) {
        paramb.emP = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.volummode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.sourcemode") != null) {
        paramb.enc = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.sourcemode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.micmode") != null) {
        paramb.enb = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.micmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.speakerMode") != null) {
        paramb.ene = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.speakerMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.phoneMode") != null) {
        paramb.enf = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.phoneMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType") != null) {
        paramb.eng = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.speakerstreamtype") != null) {
        paramb.enh = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.speakerstreamtype"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.phonestreamtype") != null) {
        paramb.eni = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.phonestreamtype"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ringphonestream") != null) {
        paramb.enk = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ringphonestream"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ringphonemode") != null) {
        paramb.enl = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ringphonemode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ringspeakerstream") != null) {
        paramb.enm = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ringspeakerstream"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ringspeakermode") != null) {
        paramb.enn = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ringspeakermode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.aecmodenew") != null) {
        paramb.eno = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.aecmodenew"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.nsmodenew") != null) {
        paramb.enp = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.nsmodenew"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcmodenew") != null) {
        paramb.enq = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcmodenew"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcmode") != null) {
        paramb.enr = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agctargetdb") != null) {
        paramb.ens = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agctargetdb"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcgaindb") != null) {
        paramb.ent = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcgaindb"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcflag") != null) {
        paramb.enu = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcflag"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agclimiter") != null) {
        paramb.env = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agclimiter"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.inputvolumescale") != null) {
        paramb.emQ = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.inputvolumescale"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.outputvolumescale") != null) {
        paramb.emR = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.outputvolumescale"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker") != null) {
        paramb.emS = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker") != null) {
        paramb.emT = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ehanceheadsetec") != null) {
        paramb.emW = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ehanceheadsetec"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset") != null) {
        paramb.emX = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker") != null) {
        paramb.emY = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec") != null) {
        paramb.emZ = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.enablerectimer") != null) {
        paramb.enw = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.enablerectimer"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.enablePlayTimer") != null) {
        paramb.enx = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.enablePlayTimer"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof0") != null)
      {
        paramb.enz[0] = ((short)bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof0"), 0));
        paramb.eny = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof1") != null)
      {
        paramb.enz[1] = ((short)bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof1"), 0));
        paramb.eny = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof2") != null)
      {
        paramb.enz[2] = ((short)bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof2"), 0));
        paramb.eny = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof3") != null)
      {
        paramb.enz[3] = ((short)bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof3"), 0));
        paramb.eny = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof4") != null)
      {
        paramb.enz[4] = ((short)bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof4"), 0));
        paramb.eny = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof5") != null)
      {
        paramb.enz[5] = ((short)bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof5"), 0));
        paramb.eny = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof6") != null)
      {
        paramb.enz[6] = ((short)bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof6"), 0));
        paramb.eny = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof7") != null)
      {
        paramb.enz[7] = ((short)bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof7"), 0));
        paramb.eny = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof8") != null)
      {
        paramb.enz[8] = ((short)bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof8"), 0));
        paramb.eny = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof9") != null)
      {
        paramb.enz[9] = ((short)bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof9"), 0));
        paramb.eny = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof10") != null)
      {
        paramb.enz[10] = ((short)bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof10"), 0));
        paramb.eny = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof11") != null)
      {
        paramb.enz[11] = ((short)bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof11"), 0));
        paramb.eny = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof12") != null)
      {
        paramb.enz[12] = ((short)bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof12"), 0));
        paramb.eny = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof13") != null)
      {
        paramb.enz[13] = ((short)bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof13"), 0));
        paramb.eny = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof14") != null)
      {
        paramb.enz[14] = ((short)bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof14"), 0));
        paramb.eny = 1;
      }
      if ((localMap.get(".deviceinfoconfig.voip.audio.correctoff") != null) && (bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctoff"), 0) == 1)) {
        paramb.eny = 0;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone") != null) {
        paramb.emU = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker") != null) {
        paramb.emV = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0") != null) {
        paramb.enA[0] = ((short)bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0"), 0));
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1") != null) {
        paramb.enA[1] = ((short)bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1"), 0));
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcrxflag") != null) {
        paramb.enK = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcrxflag"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcrxtargetdb") != null) {
        paramb.enL = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcrxtargetdb"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcrxgaindb") != null) {
        paramb.enM = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcrxgaindb"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcrxlimiter") != null) {
        paramb.enN = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcrxlimiter"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.spkecenable") != null) {
        paramb.enC = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.spkecenable"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.enableXnoiseSup") != null) {
        paramb.ena = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.enableXnoiseSup"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
        paramb.emM = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.speakermode") != null)
      {
        paramb.enE = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.speakermode"), 0);
        paramb.enD = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.phonemode") != null)
      {
        paramb.enF = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.phonemode"), 0);
        paramb.enD = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.sourcemode") != null)
      {
        paramb.enG = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.sourcemode"), 0);
        paramb.enD = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.streamtype") != null)
      {
        paramb.enH = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.streamtype"), 0);
        paramb.enD = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype") != null)
      {
        paramb.enI = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype"), 0);
        paramb.enD = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.phonestreamtype") != null)
      {
        paramb.enJ = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.phonestreamtype"), 0);
        paramb.enD = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.common.js") != null)
      {
        paramk.eoQ = true;
        paramk.eoR = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.js"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.js") != null) {
        paramk.eoI = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.js"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.stopbluetoothbr") != null) {
        paramk.eoJ = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.stopbluetoothbr"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.stopbluetoothbu") != null) {
        paramk.eoK = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.stopbluetoothbu"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.setbluetoothscoon") != null) {
        paramk.eoM = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.setbluetoothscoon"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.startbluetoothsco") != null) {
        paramk.eoL = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.startbluetoothsco"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.voicesearchfastmode") != null) {
        paramk.eoN = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.voicesearchfastmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.pcmreadmode") != null) {
        paramk.eoP = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.pcmreadmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.pcmbufferrate") != null) {
        paramk.eoO = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.pcmbufferrate"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.app") != null) {
        paramk.eoS = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.app"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp") != null) {
        paramk.epl = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns") != null) {
        paramk.epm = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec") != null) {
        paramk.epn = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc") != null) {
        paramk.epo = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.vmfd") != null) {
        paramk.eoT = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vmfd"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.htcvoicemode") != null) {
        paramk.eoU = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.htcvoicemode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.samsungvoicemode") != null) {
        paramk.eoV = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.samsungvoicemode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.speexbufferrate") != null) {
        paramk.eoW = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.speexbufferrate"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.linespe") != null) {
        paramk.eoX = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.linespe"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.fixspan") != null) {
        paramk.epi = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.fixspan"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extvideo") != null) {
        paramk.eoY = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.extvideo"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extvideosam") != null) {
        paramk.eoZ = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.extvideosam"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sysvideodegree") != null) {
        paramk.epa = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.sysvideodegree"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.mmnotify") != null) {
        paramk.epd = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.mmnotify"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extsharevcard") != null) {
        paramk.epc = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.extsharevcard"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.audioformat") != null) {
        paramk.epe = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.audioformat"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.qrcam") != null) {
        paramk.epf = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.qrcam"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sysvideofdegree") != null) {
        paramk.epb = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.sysvideofdegree"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.audioformat") != null) {
        paramk.epe = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.audioformat"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.qrcam") != null) {
        paramk.epf = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.qrcam"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.base") != null) {
        paramk.epp = ((String)localMap.get(".deviceinfoconfig.voip.common.base"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.packageinfo") != null) {
        paramk.epq = ((String)localMap.get(".deviceinfoconfig.voip.common.packageinfo"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.classloader") != null) {
        paramk.epr = ((String)localMap.get(".deviceinfoconfig.voip.common.classloader"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.resources") != null) {
        paramk.eps = ((String)localMap.get(".deviceinfoconfig.voip.common.resources"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sysvideofp") != null) {
        paramk.epg = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.sysvideofp"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extstoragedir") != null) {
        paramk.ept = ((String)localMap.get(".deviceinfoconfig.voip.common.extstoragedir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extpubdir") != null) {
        paramk.epu = ((String)localMap.get(".deviceinfoconfig.voip.common.extpubdir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extdatadir") != null) {
        paramk.epv = ((String)localMap.get(".deviceinfoconfig.voip.common.extdatadir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extrootdir") != null) {
        paramk.epw = ((String)localMap.get(".deviceinfoconfig.voip.common.extrootdir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extstoragestate") != null) {
        paramk.epx = ((String)localMap.get(".deviceinfoconfig.voip.common.extstoragestate"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extcachedir") != null) {
        paramk.epy = ((String)localMap.get(".deviceinfoconfig.voip.common.extcachedir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extvideoplayer") != null) {
        paramk.eph = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.extvideoplayer"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.loadDrawable") != null) {
        paramk.epz = ((String)localMap.get(".deviceinfoconfig.voip.common.loadDrawable"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.loadXmlResourceParser") != null) {
        paramk.epA = ((String)localMap.get(".deviceinfoconfig.voip.common.loadXmlResourceParser"));
      }
      if ((localMap.get(".deviceinfoconfig.voip.common.sensorNearFar") != null) && (1 == bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.sensorNearFar"), 0))) {
        com.tencent.mm.sdk.platformtools.SensorController.yqs = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio") != null) {
        com.tencent.mm.sdk.platformtools.SensorController.yqt = bo.getDouble((String)localMap.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio"), 0.0D);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sightFullType") != null) {
        paramk.epB = ((String)localMap.get(".deviceinfoconfig.voip.common.sightFullType"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.slyTextureView") != null) {
        paramk.epC = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.slyTextureView"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.checkSightDraftMd5") != null) {
        paramk.epD = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.checkSightDraftMd5"), 1);
      }
      label6541:
      label6935:
      label6979:
      int i;
      int j;
      int k;
      if (localMap.get(".deviceinfoconfig.voip.common.swipeBackConfig") != null)
      {
        paramk.epE = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.swipeBackConfig"), 1);
        if (paramk.epE == 1)
        {
          bool = true;
          com.tencent.mm.compatible.i.b.bS(bool);
        }
      }
      else
      {
        if (localMap.get(".deviceinfoconfig.voip.common.canDecodeWebp") != null) {
          paramk.epF = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.canDecodeWebp"), 1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.isScanZoom") != null) {
          paramk.epj = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.isScanZoom"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio") != null) {
          paramk.epk = bo.getDouble((String)localMap.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio"), -1.0D);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.notificationSetMode") != null) {
          paramk.epG = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.notificationSetMode"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.hevcTransCodeMediaCodec") != null) {
          paramk.epH = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.hevcTransCodeMediaCodec"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.videoSupportHevcDecode") != null) {
          paramk.epI = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.common.videoSupportHevcDecode"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo") != null)
        {
          if (bo.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo"), 0) != 1) {
            break label8111;
          }
          bool = true;
          paramy.erh = bool;
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.width") != null) {
          paramy.mVideoWidth = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.width"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.height") != null) {
          paramy.mVideoHeight = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.height"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.frameRate") != null) {
          paramy.eri = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.frameRate"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate") != null) {
          paramy.erj = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useSystem") != null) {
          paramy.erk = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useSystem"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek") != null) {
          paramy.erl = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC") != null) {
          paramy.erm = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate") != null) {
          paramy.ern = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera") != null) {
          paramy.ero = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useFDWithFileSize") != null) {
          paramy.erp = bo.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useFDWithFileSize"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.webview.notifythread") != null)
        {
          if (bo.getInt((String)localMap.get(".deviceinfoconfig.voip.webview.notifythread"), 0) != 1) {
            break label8117;
          }
          bool = true;
          paramae.erJ = bool;
        }
        if (localMap.get(".deviceinfoconfig.voip.webview.forceUseSysWebView") != null)
        {
          if (bo.getInt((String)localMap.get(".deviceinfoconfig.voip.webview.forceUseSysWebView"), 0) != 1) {
            break label8123;
          }
          bool = true;
          paramae.erK = bool;
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeviceInfoParser", "save forceusesystemwebview = %b", new Object[] { Boolean.valueOf(paramae.erK) });
          ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit().putBoolean("tbs_force_user_sys_webview", paramae.erK).commit();
        }
        paramk.dump();
        i = bo.getInt((String)localMap.get(".deviceinfoconfig.fingerprint.forceFingerprintStatus"), 0);
        j = bo.getInt((String)localMap.get(".deviceinfoconfig.fingerprint.supportExportEntrance"), 0);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeviceInfoParser", "hy: got fingerprint force status: %d", new Object[] { Integer.valueOf(i) });
        if (paramt != null)
        {
          paramt.iQ(i);
          paramt.iP(j);
        }
        k = bo.getInt((String)localMap.get(".deviceinfoconfig.soter.isSupport"), 0);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeviceInfoParser", "hy: get soter status: %d", new Object[] { Integer.valueOf(k) });
        if (paramab != null)
        {
          if (k <= 0) {
            break label8129;
          }
          bool = true;
          label7177:
          paramab.bR(bool);
          paramab.iS(k);
        }
        if ((i == 11) && (j == 11) && (paramab != null))
        {
          paramt.iQ(1);
          paramt.iP(1);
          paramab.bR(true);
          paramab.iS(1);
          paramab.Ma();
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeviceInfoParser", "py: hw patch is available now!");
        }
        paramo = (String)localMap.get(".deviceinfoconfig.freeWifi.operations.bizUserName");
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeviceInfoParser", "lm: got PublicNum: %s", new Object[] { paramo });
        if (paramx != null) {
          paramx.ln(paramo);
        }
        paramString = br.F(paramString, "manufacturerName");
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeviceInfoParser", "lm: got manufacturerNameMaps: %s", new Object[] { paramString });
        if (paramx != null) {
          paramx.f(paramString);
        }
        i = bo.getInt((String)localMap.get(".deviceinfoconfig.style.swipback"), 0);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeviceInfoParser", "lm: got swipback: %d", new Object[] { Integer.valueOf(i) });
        if (paramx != null) {
          paramx.iR(i);
        }
        i = bo.getInt((String)localMap.get(".deviceinfoconfig.game.isLimit"), 0);
        paramString = (String)localMap.get(".deviceinfoconfig.game.limitPrompt");
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeviceInfoParser", "lm: get game status: %d,gamePrompt:%s", new Object[] { Integer.valueOf(i), paramString });
        if (parama != null) {
          if (i != 1) {
            break label8135;
          }
        }
      }
      label8111:
      label8117:
      label8123:
      label8129:
      label8135:
      for (boolean bool = true;; bool = false)
      {
        parama.bO(bool);
        parama.lh(paramString);
        i = bo.getInt((String)localMap.get(".deviceinfoconfig.mmsight.recordertype"), -1);
        j = bo.getInt((String)localMap.get(".deviceinfoconfig.mmsight.needRotateEachFrame"), -1);
        k = bo.getInt((String)localMap.get(".deviceinfoconfig.mmsight.enableHighResolutionRecord"), -1);
        int m = bo.getInt((String)localMap.get(".deviceinfoconfig.mmsight.landscapeRecordModeEnable"), -1);
        int n = bo.getInt((String)localMap.get(".deviceinfoconfig.mmsight.transcodeDecoderType"), -1);
        int i1 = bo.getInt((String)localMap.get(".deviceinfoconfig.mmsight.mediaPlayerType"), -1);
        int i2 = bo.getInt((String)localMap.get(".deviceinfoconfig.mmsight.strategyMask"), -1);
        int i3 = bo.getInt((String)localMap.get(".deviceinfoconfig.mmsight.recorderOption"), -1);
        int i4 = bo.getInt((String)localMap.get(".deviceinfoconfig.mmsight.useMetering"), -1);
        int i5 = bo.getInt((String)localMap.get(".deviceinfoconfig.mmsight.transcodeEncoderType"), -1);
        int i6 = bo.getInt((String)localMap.get(".deviceinfoconfig.mmsight.checkSendVideoBitrate"), -1);
        int i7 = bo.getInt((String)localMap.get(".deviceinfoconfig.mmsight.cpuCrop"), -1);
        int i8 = bo.getInt((String)localMap.get(".deviceinfoconfig.mmsight.storyRecorderType"), -1);
        int i9 = bo.getInt((String)localMap.get(".deviceinfoconfig.mmsight.backgroundRemux"), -1);
        int i10 = bo.getInt((String)localMap.get(".deviceinfoconfig.mmsight.emojiPreviewSize"), -1);
        int i11 = bo.getInt((String)localMap.get(".deviceinfoconfig.mmsight.emojiStickerSampleSize"), -1);
        int i12 = bo.getInt((String)localMap.get(".deviceinfoconfig.mmsight.emojiUseSmallModel"), -1);
        int i13 = bo.getInt((String)localMap.get(".deviceinfoconfig.mmsight.emojiUseGpuSegment"), -1);
        int i14 = bo.getInt((String)localMap.get(".deviceinfoconfig.mmsight.c2cRemuxUseSoftEncode"), -1);
        int i15 = bo.getInt((String)localMap.get(".deviceinfoconfig.mmsight.snsRemuxUseSoftEncode"), -1);
        if (paramw1 != null)
        {
          paramw1.eqK = i;
          paramw1.eqL = j;
          paramw1.eqM = k;
          paramw1.eqN = m;
          paramw1.eqO = n;
          paramw1.eqP = i1;
          paramw1.eqQ = i2;
          paramw1.eqR = i3;
          paramw1.eqS = i4;
          paramw1.eqT = i5;
          paramw1.eqU = i6;
          paramw1.eqX = i10;
          paramw1.eqY = i11;
          paramw1.eqZ = i12;
          paramw1.era = i13;
          paramw1.erb = i14;
          paramw1.erc = i15;
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeviceInfoParser", "get mmSightRecorderInfo: %s", new Object[] { paramw1.toString() });
        }
        if (paramw2 != null)
        {
          paramw2.eqK = i8;
          paramw2.eqL = j;
          paramw2.eqM = k;
          paramw2.eqN = m;
          paramw2.eqO = n;
          paramw2.eqP = i1;
          paramw2.eqQ = i2;
          paramw2.eqR = i3;
          paramw2.eqS = i4;
          paramw2.eqT = i5;
          paramw2.eqU = i6;
          paramw2.eqV = i7;
          paramw2.eqW = i9;
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeviceInfoParser", "get mmStoryRecorderInfo: %s", new Object[] { paramw2.toString() });
        }
        AppMethodBeat.o(92991);
        return true;
        bool = false;
        break;
        bool = false;
        break label6541;
        bool = false;
        break label6935;
        bool = false;
        break label6979;
        bool = false;
        break label7177;
      }
      return false;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.DeviceInfoParser", paramString, "", new Object[0]);
      AppMethodBeat.o(92991);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.e.s
 * JD-Core Version:    0.7.0.1
 */