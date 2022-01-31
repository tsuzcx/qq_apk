package com.tencent.filter;

import android.graphics.Bitmap;

public class GLSLRender
{
  public static int GL_TEXTURE_2D = 3553;
  public static int btA;
  public static int btB;
  public static int btC;
  public static int btD;
  public static int btE;
  public static int btF;
  public static int btG;
  public static int btH;
  public static int btI;
  public static int btJ;
  public static int btK;
  public static int btL;
  public static int btM;
  public static int btN;
  public static int btO;
  public static int btP;
  public static int btQ;
  public static int btR;
  public static int btS;
  public static int btT;
  public static int btU;
  public static int btV;
  public static int btW;
  public static int btX;
  public static int btY;
  public static int btZ;
  public static int btg = 0;
  public static int bth = 1;
  public static int bti = 2;
  public static int btj = 3;
  public static int btk = 4;
  public static int btl = 5;
  public static int btm = 6;
  public static int btn = 7;
  public static int bto = 8;
  public static int btp = 9;
  public static int btq = 10;
  public static int btr = 11;
  public static int bts = 12;
  public static int btt = 13;
  public static int btu = 14;
  public static int btv = 15;
  public static int btw = 16;
  public static int btx = 17;
  public static int bty = 18;
  public static int btz = 19;
  public static int buA;
  public static int buB;
  public static int buC;
  public static int buD;
  public static int buE;
  public static int buF;
  public static int buG;
  public static int buH;
  public static int buI;
  public static int buJ;
  public static int buK;
  public static int buL;
  public static int buM;
  public static int buN;
  public static int buO;
  public static int buP;
  public static int buQ;
  public static int buR;
  public static int buS;
  public static int buT;
  public static int buU;
  public static int buV;
  public static int buW;
  public static int buX;
  public static int buY;
  public static int buZ;
  public static int bua;
  public static int bub;
  public static int buc;
  public static int bud;
  public static int bue;
  public static int bug;
  public static int buh;
  public static int bui;
  public static int buj;
  public static int buk;
  public static int bul;
  public static int bum;
  public static int bun;
  public static int buo;
  public static int bup;
  public static int buq;
  public static int bur;
  public static int bus;
  public static int but;
  public static int buu;
  public static int buv;
  public static int buw;
  public static int bux;
  public static int buy;
  public static int buz;
  public static int bvA;
  public static int bvB;
  public static int bvC;
  public static int bvD;
  public static int bvE;
  public static int bvF;
  public static int bvG;
  public static int bvH;
  public static int bvI;
  public static int bvJ;
  public static int bvK;
  public static int bvL;
  public static int bvM;
  public static int bvN;
  public static int bvO;
  public static int bvP;
  public static int bvQ;
  public static int bvR = 0;
  public static int bvS = 1;
  public static int bvT = 2;
  public static int bvU = 3;
  public static int bvV = 4;
  public static int bvW = 5;
  public static int bvX = 6;
  public static int bvY = 7;
  public static int bvZ = 8;
  public static int bva;
  public static int bvb;
  public static int bvc;
  public static int bvd;
  public static int bve;
  public static int bvf;
  public static int bvg;
  public static int bvh;
  public static int bvi;
  public static int bvj;
  public static int bvk;
  public static int bvl;
  public static int bvm;
  public static int bvn;
  public static int bvo;
  public static int bvp;
  public static int bvq;
  public static int bvr;
  public static int bvs;
  public static int bvt;
  public static int bvu;
  public static int bvv;
  public static int bvw;
  public static int bvx;
  public static int bvy;
  public static int bvz;
  public static int bwa = 9;
  public static int bwb = 10;
  public static int bwc = 11;
  public static int bwd = 12;
  public static int bwe = 13;
  
  static
  {
    btA = 20;
    btB = 21;
    btC = 22;
    btD = 23;
    btE = 24;
    btF = 25;
    btG = 26;
    btH = 27;
    btI = 28;
    btJ = 29;
    btK = 30;
    btL = 31;
    btM = 32;
    btN = 33;
    btO = 34;
    btP = 35;
    btQ = 36;
    btR = 37;
    btS = 38;
    btT = 39;
    btU = 40;
    btV = 41;
    btW = 42;
    btX = 43;
    btY = 44;
    btZ = 45;
    bua = 46;
    bub = 47;
    buc = 48;
    bud = 49;
    bue = 50;
    bug = 51;
    buh = 52;
    bui = 53;
    buj = 54;
    buk = 55;
    bul = 56;
    bum = 57;
    bun = 58;
    buo = 59;
    bup = 60;
    buq = 61;
    bur = 62;
    bus = 63;
    but = 64;
    buu = 65;
    buv = 66;
    buw = 67;
    bux = 68;
    buy = 69;
    buz = 70;
    buA = 71;
    buB = 72;
    buC = 73;
    buD = 74;
    buE = 75;
    buF = 76;
    buG = 77;
    buH = 78;
    buI = 79;
    buJ = 80;
    buK = 81;
    buL = 82;
    buM = 83;
    buN = 84;
    buO = 85;
    buP = 86;
    buQ = 87;
    buR = 88;
    buS = 89;
    buT = 90;
    buU = 91;
    buV = 92;
    buW = 93;
    buX = 94;
    buY = 95;
    buZ = 96;
    bva = 97;
    bvb = 98;
    bvc = 99;
    bvd = 100;
    bve = 101;
    bvf = 102;
    bvg = 103;
    bvh = 104;
    bvi = 105;
    bvj = 106;
    bvk = 107;
    bvl = 108;
    bvm = 109;
    bvn = 110;
    bvo = 111;
    bvp = 112;
    bvq = 113;
    bvr = 114;
    bvs = 115;
    bvt = 116;
    bvu = 117;
    bvv = 118;
    bvw = 119;
    bvx = 120;
    bvy = 121;
    bvz = 122;
    bvA = 123;
    bvB = 124;
    bvC = 125;
    bvD = 126;
    bvE = 127;
    bvF = 128;
    bvG = 129;
    bvH = 130;
    bvI = 131;
    bvJ = 132;
    bvK = 133;
    bvL = 134;
    bvM = 135;
    bvN = 136;
    bvO = 137;
    bvP = 138;
    bvQ = 36197;
  }
  
  public static native long nativeAllocBuffer(int paramInt);
  
  public static native void nativeBeginUseEglImage(int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeCalHistogramFromGPU(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, int paramInt6, float paramFloat3, float paramFloat4);
  
  public static native int nativeCheckMagicEngine(int paramInt1, int paramInt2);
  
  public static native int nativeCopyPixelToBitmap(Bitmap paramBitmap);
  
  public static native int nativeCopyPixelToBitmapWithShare(Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  public static native void nativeCopyTexturToDataWithShare(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4);
  
  public static native QImage nativeCopyTexture(int paramInt1, int paramInt2);
  
  public static native void nativeCopyTexture2(QImage paramQImage);
  
  public static native QImage nativeCopyTextureWithShare(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static native int nativeDeinitMagicEngine(int paramInt);
  
  public static native void nativeEndUseEglImage(int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeFreeBuffer(long paramLong);
  
  public static native int nativeInitMagicEngine(int paramInt1, int paramInt2);
  
  public static native void nativePickJepgToTexture(QImage paramQImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt);
  
  public static native void nativePreprocessJepg(QImage paramQImage, int[] paramArrayOfInt);
  
  public static native void nativePreviewData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativePreviewYuvData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativePushBitmapFromTexture(Bitmap paramBitmap, int paramInt);
  
  public static native void nativePushDataFromTexture(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativePushJepgFromTexture(QImage paramQImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public static native int nativeRenderPixelToBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  public static native int nativeSnap(Bitmap paramBitmap);
  
  public static native void nativeTextCure(int[] paramArrayOfInt, int paramInt);
  
  public static native void nativeTextImage(QImage paramQImage, int paramInt);
  
  public static native void nativeToRGBData(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native void nativeUpdateScaleBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.filter.GLSLRender
 * JD-Core Version:    0.7.0.1
 */